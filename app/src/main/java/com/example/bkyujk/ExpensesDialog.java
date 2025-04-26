package com.example.bkyujk;

import static java.security.AccessController.getContext;

import android.graphics.Typeface;
import android.media.TimedText;
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

import org.w3c.dom.Text;

import java.util.List;

public class ExpensesDialog extends BottomSheetDialogFragment {
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

            // each prod
            for (ShoppingListModel item : list) {
                // a bit of xml to get price a the end of the line :p
                LinearLayout rowLayout = new LinearLayout(getContext());
                rowLayout.setOrientation(LinearLayout.HORIZONTAL);
                rowLayout.setPadding(8,8,8,8);

                TextView it = new TextView(getContext()); //items
                it.setText("- " + item.getElement());
                it.setTextSize(16);
                it.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));

                TextView pr = new TextView(getContext()); //price
                double price = Category.getPriceForItem(item.getElement());
                pr.setText(String.format("%.2f€", price));
                pr.setTextSize(16);
                pr.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);

                rowLayout.addView(it);
                rowLayout.addView(pr);

                productListLayout.addView(rowLayout);
            }

            // total
            LinearLayout totL = new LinearLayout(getContext());
            totL.setOrientation(LinearLayout.HORIZONTAL);
            totL.setPadding(8,16,8,16);

            TextView tot = new TextView(getContext());
            tot.setText("Total:");
            tot.setTextSize(18);
            tot.setTypeface(null, Typeface.BOLD);
            tot.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));

            TextView val = new TextView(getContext());
            double res = 0.0;
            // computing
            for (ShoppingListModel item : list) {
                res += Category.getPriceForItem(item.getElement());
            }
            val.setText(String.format("%.2f€", res));
            val.setTextSize(18);
            val.setTypeface(null, Typeface.BOLD);
            val.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);

            totL.addView(tot);
            totL.addView(val);
            productListLayout.addView(totL);
        }
        return view;
    }

    private static final String ARG_MESSAGE = "message";

    public static ExpensesDialog newInstance(String message) {
        ExpensesDialog fragment = new ExpensesDialog();
        Bundle args = new Bundle();
        args.putString(ARG_MESSAGE, message);
        fragment.setArguments(args);
        return fragment;
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




