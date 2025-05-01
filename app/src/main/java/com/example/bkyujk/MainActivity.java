package com.example.bkyujk;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ShortcutInfo;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnDialogCloseListener {

    RecyclerView recyclerView;
    FloatingActionButton addButton;
    DataBaseHelper myDB;

    private List<ShoppingListModel> mList;
    private ToDoAdapter adapter;
    private TextView value2;

    Spinner spinner;
    String selectedListName;
    int selectedListId = -1;

    Button addListButton;
    Button deleteListButton;

    List<String> listNames;
    ArrayAdapter<String> adapterSpinner;

    SwitchCompat switchMode;
    boolean nightMode;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Views
        RelativeLayout budgetContainer = findViewById(R.id.budgetContainer);
        RelativeLayout expensesContainer = findViewById(R.id.enpensesContainer);
        TextView value1 = findViewById(R.id.value1);
        value2 = findViewById(R.id.value2);
        spinner = findViewById(R.id.spinner_lists);
        addListButton = findViewById(R.id.button_add_list);
        deleteListButton = findViewById(R.id.button_delete_list);

        SharedPreferences prefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
        String saveBudget = prefs.getString("budget", null);
        if (saveBudget != null) {
            value1.setText(saveBudget);
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

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Init lists and spinner
        listNames = myDB.getAllListNames();
        if (listNames.isEmpty()) {
            myDB.insertList("My List");
            listNames = myDB.getAllListNames();
        }

        adapterSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listNames);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);

        selectedListName = listNames.get(0);
        selectedListId = myDB.getListIdByName(selectedListName);
        loadListForSelectedId();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedListName = parent.getItemAtPosition(position).toString();
                selectedListId = myDB.getListIdByName(selectedListName);
                loadListForSelectedId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        addListButton.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Name of the new list");

            final EditText input = new EditText(MainActivity.this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            builder.setPositiveButton("Create", (dialog, which) -> {
                String newListName = input.getText().toString().trim();
                if (!newListName.isEmpty()) {
                    if (!listNames.contains(newListName)) {
                        myDB.insertList(newListName);

                        listNames.clear();
                        listNames.addAll(myDB.getAllListNames());
                        adapterSpinner.notifyDataSetChanged();

                        int index = listNames.indexOf(newListName);
                        if (index >= 0) {
                            spinner.setSelection(index);
                        }

                        Toast.makeText(MainActivity.this, "List added", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "This name already exist", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Entrer a name", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
            builder.show();
        });

        deleteListButton.setOnClickListener(v -> {
            if (listNames.size() <= 1) {
                Toast.makeText(MainActivity.this, "Impossible to delete the last list", Toast.LENGTH_SHORT).show();
                return;
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Delete list ?");
            builder.setMessage("This will also delete all associated elements.");
            builder.setPositiveButton("Delete", (dialog, which) -> {
                myDB.deleteListById(selectedListId);

                listNames.clear();
                listNames.addAll(myDB.getAllListNames());
                adapterSpinner.notifyDataSetChanged();

                selectedListName = listNames.get(0);
                selectedListId = myDB.getListIdByName(selectedListName);
                spinner.setSelection(0);
                loadListForSelectedId();

                Toast.makeText(MainActivity.this, "List deleted", Toast.LENGTH_SHORT).show();
            });

            builder.setNegativeButton("Cancelled", (dialog, which) -> dialog.dismiss());
            builder.show();
        });

        addButton.setOnClickListener(view -> {
            AddNewElem addNewElem = AddNewElem.newInstance();
            Bundle bundle = new Bundle();
            bundle.putInt("listId", selectedListId);
            addNewElem.setArguments(bundle);
            addNewElem.show(getSupportFragmentManager(), AddNewElem.TAG);
        });

        budgetContainer.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Enter your budget");

            final EditText input = new EditText(MainActivity.this);
            input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
            builder.setView(input);

            builder.setPositiveButton("OK", (dialog, which) -> {
                String enteredValue = input.getText().toString();
                try {
                    double budget = Double.parseDouble(enteredValue);
                    if (budget > 0) {
                        value1.setText(enteredValue);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("budget", enteredValue);
                        editor.apply();
                        andrewTate();
                    } else {
                        Toast.makeText(MainActivity.this, "Please enter a value greater than 0.", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid number", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
            builder.show();
        });

        expensesContainer.setOnClickListener(v -> {
            String message = "Expenses Detail";
            ExpensesDialog.newInstance(message).show(getSupportFragmentManager(), "ExpensesDialog");
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new RecyclerViewTouchHelper(adapter, this));
        itemTouchHelper.attachToRecyclerView(recyclerView);

        switchMode = findViewById(R.id.switchMode);

        sharedPreferences = getSharedPreferences("MODE", Context.MODE_PRIVATE);
        nightMode = sharedPreferences.getBoolean("nightMode",false);

        if(nightMode) {
            switchMode.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        switchMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nightMode){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("nightMode",false);

                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("nightMode",true);
                }
                editor.apply();
            }
        });

        Button doneButton = findViewById(R.id.button_done);
        doneButton.setOnClickListener(v -> {
            List<ShoppingListModel> list = myDB.getElementsByListId(selectedListId);

            // not done
            if (list.isEmpty()) {
                Toast.makeText(MainActivity.this, "Your list is empty.", Toast.LENGTH_SHORT).show();
                return;
            }

            List<ShoppingListModel> notCheck = new ArrayList<>();
            int cmp = 0;
            double total = 0.0;

            for (ShoppingListModel item : list) {
                if (item.getStatus() != 1) {
                    notCheck.add(item);
                } else {
                    cmp++;
                    total += item.getPrice();
                }
            }

            // clic done -> positive
            if (notCheck.isEmpty()) {
                String message = String.format("%d items for a total of %.2f€", cmp, total);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Your are all good")
                        .setMessage(message)
                        .setPositiveButton("OK", null)
                        .show();
            } else {
                StringBuilder sb = new StringBuilder("Some items are missing:\n");
                for (ShoppingListModel item : notCheck) {
                    sb.append("  - ").append(item.getElement())
                            .append("\n");
                }
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Remaining items")
                        .setMessage(sb.toString())
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
    }

    private void loadListForSelectedId() {
        mList = myDB.getElementsByListId(selectedListId);
        Collections.reverse(mList);
        adapter.setElements(mList);
        updateExpenses(value2);
    }

    @Override
    public void onDialogClose(DialogInterface dialogInterface) {
        loadListForSelectedId();
        adapter.notifyDataSetChanged();
    }

    public void updateExpenses(TextView value2) {
        List<ShoppingListModel> list = myDB.getElementsByListId(selectedListId);
        double total = 0.0;
        for (ShoppingListModel item : list) {
            total += Category.getPriceForItem(item.getElement());
        }
        value2.setText(String.format("%.2f", total));

        andrewTate();
    }

    public void refreshUI() {
        loadListForSelectedId();
        adapter.notifyDataSetChanged();
    }

    private void andrewTate() {
        TextView value1 = findViewById(R.id.value1);
        TextView value2 = findViewById(R.id.value2);

        try {
            double budget = Double.parseDouble(value1.getText().toString().replace("euro", "").trim());
            double expenses = Double.parseDouble(value2.getText().toString().replace("euro", "").trim());

            if (expenses > budget) {
                value2.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                String message = String.format("Please add %.2f€ to your budget.", expenses - budget);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Budget exceeded")
                        .setMessage(message)
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .show();
            } else {
                value2.setTextColor(getResources().getColor(android.R.color.black));
            }
        } catch (NumberFormatException e) {
            value2.setTextColor(getResources().getColor(android.R.color.black));
        }
    }
}
