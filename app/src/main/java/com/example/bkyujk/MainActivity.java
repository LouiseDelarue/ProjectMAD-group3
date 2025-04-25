package com.example.bkyujk;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bkyujk.Adapter.ToDoAdapter;
import com.example.bkyujk.Model.ShoppingListModel;
import com.example.bkyujk.Utils.DataBaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnDialogCloseListener {

    RecyclerView recyclerView;
    FloatingActionButton addButton;
    DataBaseHelper myDB;

    private List<ShoppingListModel> mList;
    private ToDoAdapter adapter;
    private TextView value2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        RelativeLayout budgetContainer = findViewById(R.id.budgetContainer);
        RelativeLayout expensesContainer = findViewById(R.id.enpensesContainer);

        TextView value1 = findViewById(R.id.value1);


        SharedPreferences prefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
        String saveBudget = prefs.getString("budget", null);
        if (saveBudget != null) {
            value1.setText((saveBudget));
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        addButton = findViewById(R.id.addButton);


        myDB = new DataBaseHelper(MainActivity.this);
        mList = new ArrayList<>();
        adapter = new ToDoAdapter(myDB, MainActivity.this);

        value2 = findViewById(R.id.value2);
        updateExpenses(value2);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        mList = myDB.getAllElements();
        Collections.reverse(mList);
        adapter.setElements(mList);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddNewElem.newInstance().show(getSupportFragmentManager(), AddNewElem.TAG);
            }
        });

        // Edit budget
        budgetContainer.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Enter your budget");

            final EditText input = new EditText(MainActivity.this);
            input.setInputType(
                    InputType.TYPE_CLASS_NUMBER |
                    InputType.TYPE_NUMBER_FLAG_DECIMAL);
            builder.setView(input);

            builder.setPositiveButton("OK", (dialog, which) -> {
                String enteredValue = input.getText().toString();
                try { //verif si budget >0
                    double budget = Double.parseDouble(enteredValue);
                    if (budget>0) {
                        value1.setText(enteredValue);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("budget", enteredValue);
                        editor.apply();
                        andrewTate();
                    } else {
                        Toast.makeText(MainActivity.this, "PLease enter a value greater than 0.", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "invalid number", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
            builder.show();
        });

        // Edit expenses
        expensesContainer.setOnClickListener(v -> {
            String message = "Expenses Detail";

            ExpensesDialog.newInstance(message).show(getSupportFragmentManager(), "ExpensesDialog");
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new RecyclerViewTouchHelper(adapter, this));
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void onDialogClose(DialogInterface dialogInterface) {
        mList = myDB.getAllElements();
        Collections.reverse(mList);
        adapter.setElements(mList);
        adapter.notifyDataSetChanged();
        updateExpenses(value2);
    }

    public void updateExpenses(TextView value2) {
        List<ShoppingListModel> list = myDB.getAllElements();
        double total = 0.0;
        for (ShoppingListModel item : list) {
            total += Category.getPriceForItem(item.getElement());
        }
        value2.setText(String.format("%.2f", total));
        andrewTate();
    }

    public void refreshUI() {
        mList = myDB.getAllElements();
        Collections.reverse(mList);
        adapter.setElements(mList);
        adapter.notifyDataSetChanged();
        updateExpenses(value2);
    }

    private void andrewTate() { // expenses become red if poor budget
        TextView value1 = findViewById(R.id.value1);
        TextView value2 = findViewById(R.id.value2);

        try {
            double budget = Double.parseDouble(value1.getText().toString().replace("euro", "").trim());
            double expenses = Double.parseDouble(value2.getText().toString().replace("euro", "").trim());

            if (expenses > budget) {
                value2.setTextColor(getResources().getColor(android.R.color.holo_red_light));
            } else {
                value2.setTextColor(getResources().getColor(android.R.color.black));
            }
        } catch (NumberFormatException e) {
            value2.setTextColor(getResources().getColor(android.R.color.black));
        }
    }
}








