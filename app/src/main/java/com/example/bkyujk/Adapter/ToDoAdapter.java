package com.example.bkyujk.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bkyujk.AddNewElem;
import com.example.bkyujk.MainActivity;
import com.example.bkyujk.Model.ShoppingListModel;
import com.example.bkyujk.R;
import com.example.bkyujk.Utils.DataBaseHelper;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.MyViewHolder  > {

    private List<ShoppingListModel> mList;
    private MainActivity activity;
    private DataBaseHelper myDB;
    public ToDoAdapter (DataBaseHelper myDB, MainActivity activity)
    {
        this.activity = activity;
        this.myDB = myDB;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ShoppingListModel elem = mList.get(position);
        holder.checkBox.setText(elem.getElement());
        holder.checkBox.setChecked(tobool(elem.getStatus()));
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(compoundButton.isChecked())
                {
                    myDB.updateStatus(elem.getId(), 1);
                }
                else
                {
                    myDB.updateStatus(elem.getId(), 0);
                }
            }
        });
    }

    public boolean tobool (int num)
    {
        return num!= 0;
    }

    public Context getContext()
    {
        return activity;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setElements(List<ShoppingListModel> mList)
    {
        this.mList = mList;
        notifyDataSetChanged();
    }

    public void deleteElement(int position)
    {
        ShoppingListModel elem = mList.get(position);
        myDB.deleteElement(elem.getId());

        mList.remove(position);
        notifyItemRemoved(position);
    }

    public void editElement(int position)
    {
        ShoppingListModel elem = mList.get(position);
        Bundle bundle = new Bundle();
        bundle.putInt("ID", elem.getId());
        bundle.putString("element", elem.getElement());

        AddNewElem addNewElem = new AddNewElem();
        addNewElem.setArguments(bundle);
        addNewElem.show(activity.getSupportFragmentManager(), addNewElem.getTag());
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkbox);

        }
    }
}
