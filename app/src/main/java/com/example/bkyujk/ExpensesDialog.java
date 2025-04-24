package com.example.bkyujk;

import static java.security.AccessController.getContext;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bkyujk.Model.ShoppingListModel;
import com.example.bkyujk.Utils.DataBaseHelper;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;

public class ExpensesDialog extends BottomSheetDialogFragment {
    private static final String ARG_MESSAGE = "message";

    public static ExpensesDialog newInstance(String message) {
        ExpensesDialog fragment = new ExpensesDialog();
        Bundle args = new Bundle();
        args.putString(ARG_MESSAGE, message);
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.dialog_expenses_detail, container, false);

        TextView expensesTitle = view.findViewById(R.id.expensesTitle);
        TextView emptyListText = view.findViewById(R.id.emptyListText);
        LinearLayout productListLayout = view.findViewById(R.id.productListLayout);

        String message = getArguments() != null ? getArguments().getString(ARG_MESSAGE) : "";
        expensesTitle.setText(message);

        // Display what's in the list
        DataBaseHelper myDB = new DataBaseHelper(getContext());
        List<ShoppingListModel> list = myDB.getAllElements();

        if (list.isEmpty()) { // no more gone
            emptyListText.setVisibility(View.VISIBLE);
            productListLayout.setVisibility(View.GONE);
        } else {
            emptyListText.setVisibility(View.GONE);
            productListLayout.setVisibility(View.VISIBLE);

            for (ShoppingListModel item : list) {
                TextView itemView = new TextView(getContext());
                itemView.setText("- " + item.getElement());
                itemView.setTextSize(16);
                itemView.setPadding(8, 8, 8, 8);
                productListLayout.addView(itemView);
            }
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null && getDialog().getWindow() != null) {
            WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
            layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
            layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
            getDialog().getWindow().setAttributes(layoutParams);
        }
    }
}




