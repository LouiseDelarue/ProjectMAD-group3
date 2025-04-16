package com.example.bkyujk;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
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

        mList = myDB.getAllElements();
        Collections.reverse(mList);
        adapter.setElements(mList);



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddNewElem.newInstance().show(getSupportFragmentManager(), AddNewElem.TAG);
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new RecyclerViewTouchHelper(adapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void onDialogClose(DialogInterface dialogInterface) {
        mList = myDB.getAllElements();
        Collections.reverse(mList);
        adapter.setElements(mList);
        adapter.notifyDataSetChanged();
    }
}