package com.example.bkyujk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bkyujk.Model.ShoppingListModel;
import com.example.bkyujk.Utils.DataBaseHelper;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class AddNewElem extends BottomSheetDialogFragment {

    public static final String TAG = "AddNewElem";
    private AutoCompleteTextView mEditText;
    private Button mSaveButton;

    private DataBaseHelper myDB;

    public static AddNewElem newInstance() {
        return new AddNewElem();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_new_element, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mEditText = view.findViewById(R.id.editText);
        mSaveButton = view.findViewById(R.id.addButton);

        myDB = new DataBaseHelper(getActivity());

        // Autocomplétion des produits
        List<String> allProducts = new ArrayList<>(Category.GAA_hurling());
        ArrayAdapter<String> adapterAuto = new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line, allProducts);
        mEditText.setAdapter(adapterAuto);
        mEditText.setThreshold(1);

        boolean isUpdate = false;
        int listId = -1;
        int itemId = -1;

        Bundle bundle = getArguments();
        if (bundle != null) {
            listId = bundle.getInt("listId", -1); // 👈 récupération du listId
            if (bundle.containsKey("element") && bundle.containsKey("ID")) {
                isUpdate = true;
                itemId = bundle.getInt("ID");
                String element = bundle.getString("element");
                mEditText.setText(element);

                if (element.length() > 0) {
                    mSaveButton.setEnabled(false);
                }
            }
        }

        final int finalListId = listId;
        final boolean finalIsUpdate = isUpdate;
        final int finalItemId = itemId;

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().isEmpty()) {
                    mSaveButton.setEnabled(false);
                    mSaveButton.setBackgroundColor(Color.GRAY);
                } else {
                    mSaveButton.setEnabled(true);
                }
            }
            @Override public void afterTextChanged(Editable s) {}
        });

        mSaveButton.setOnClickListener(v -> {
            String rawText = mEditText.getText().toString().trim();
            final String text = capitalizeFirstLetter(rawText);

            if (finalIsUpdate) {
                // 👉 mise à jour complète : texte + catégorie
                String category = Category.getCategoryForItem(text);
                ShoppingListModel updated = new ShoppingListModel();
                updated.setId(finalItemId);
                updated.setElement(text);
                updated.setStatus(0);
                updated.setCategory(category);
                updated.setListId(finalListId);
                updated.setPrice(Category.getPriceForItem(text));
                myDB.updateElement(updated);
                dismiss();
                return;
            }

            ShoppingListModel elem = new ShoppingListModel();
            elem.setElement(text);
            elem.setStatus(0);
            elem.setListId(finalListId);

            String category = Category.getCategoryForItem(text);
            if (category.equals("Autres")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("What's the price for it?");

                final EditText input = new EditText(getContext());
                input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                builder.setView(input);

                builder.setPositiveButton("OK", (dialog, which) -> {
                    try {
                        double price = Double.parseDouble(input.getText().toString());
                        Category.OQTF(text, price);

                        elem.setCategory("Autres");
                        elem.setPrice(price);
                        myDB.insertElement(elem);
                        dismiss();
                    } catch (NumberFormatException e) {
                        Toast.makeText(getContext(), "Invalid number", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
                builder.show();
            } else {
                elem.setCategory(category);
                elem.setPrice(Category.getPriceForItem(text));
                myDB.insertElement(elem);
                dismiss();
            }
        });
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        Activity activity = getActivity();
        if (activity instanceof OnDialogCloseListener) {
            ((OnDialogCloseListener) activity).onDialogClose(dialog);
        }
    }

    private String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}

