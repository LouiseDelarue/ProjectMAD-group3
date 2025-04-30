package com.example.bkyujk.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bkyujk.Model.ShoppingListModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Shopping_DATABASE";
    private static final int DATABASE_VERSION = 3;

    private static final String TABLE_ITEMS = "Shopping_TABLE";
    private static final String TABLE_LISTS = "Lists_TABLE";

    // Shopping_TABLE columns
    private static final String COL_ITEM_ID = "ID";
    private static final String COL_ELEMENT = "ELEMENT";
    private static final String COL_STATUS = "STATUS";
    private static final String COL_CATEGORY = "CATEGORY";
    private static final String COL_LIST_ID = "LIST_ID";

    // Lists_TABLE columns
    private static final String COL_LIST_ID_ONLY = "LIST_ID";
    private static final String COL_LIST_NAME = "LIST_NAME";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_LISTS + " (" +
                COL_LIST_ID_ONLY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_LIST_NAME + " TEXT)");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_ITEMS + " (" +
                COL_ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_ELEMENT + " TEXT, " +
                COL_STATUS + " INTEGER, " +
                COL_CATEGORY + " TEXT, " +
                COL_LIST_ID + " INTEGER, " +
                "FOREIGN KEY(" + COL_LIST_ID + ") REFERENCES " + TABLE_LISTS + "(" + COL_LIST_ID_ONLY + "))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LISTS);
        onCreate(db);
    }

    // Créer une nouvelle liste
    public long insertList(String listName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_LIST_NAME, listName);
        return db.insert(TABLE_LISTS, null, cv);
    }

    // Récupérer toutes les listes
    public List<String> getAllListNames() {
        List<String> listNames = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LISTS, new String[]{COL_LIST_NAME}, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                listNames.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return listNames;
    }

    public int getListIdByName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LISTS, new String[]{COL_LIST_ID_ONLY}, COL_LIST_NAME + "=?", new String[]{name}, null, null, null);
        if (cursor.moveToFirst()) {
            int id = cursor.getInt(0);
            cursor.close();
            return id;
        } else {
            cursor.close();
            return -1;
        }
    }

    // Insérer un élément
    public void insertElement(ShoppingListModel model) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ELEMENT, model.getElement());
        contentValues.put(COL_STATUS, 0);
        contentValues.put(COL_CATEGORY, model.getCategory());
        contentValues.put(COL_LIST_ID, model.getListId());
        db.insert(TABLE_ITEMS, null, contentValues);
    }

    public List<ShoppingListModel> getElementsByListId(int listId) {
        SQLiteDatabase db = this.getReadableDatabase();
        List<ShoppingListModel> shoppingList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_ITEMS, null, COL_LIST_ID + "=?", new String[]{String.valueOf(listId)}, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                ShoppingListModel model = new ShoppingListModel();
                model.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COL_ITEM_ID)));
                model.setElement(cursor.getString(cursor.getColumnIndexOrThrow(COL_ELEMENT)));
                model.setStatus(cursor.getInt(cursor.getColumnIndexOrThrow(COL_STATUS)));
                model.setCategory(cursor.getString(cursor.getColumnIndexOrThrow(COL_CATEGORY)));
                model.setListId(cursor.getInt(cursor.getColumnIndexOrThrow(COL_LIST_ID)));
                shoppingList.add(model);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return shoppingList;
    }

    public void updateElement(ShoppingListModel model) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ELEMENT", model.getElement());
        contentValues.put("STATUS", model.getStatus());
        contentValues.put("CATEGORY", model.getCategory());
        contentValues.put("LIST_ID", model.getListId());
        db.update("Shopping_TABLE", contentValues, "ID=?", new String[]{String.valueOf(model.getId())});
    }

    public void updateStatus(int id, int status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS", status);
        db.update("Shopping_TABLE", contentValues, "ID=?", new String[]{String.valueOf(id)});
    }

    public void deleteElement(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Shopping_TABLE", "ID=?", new String[]{String.valueOf(id)});
    }

    // Autres méthodes (update, delete) restent les mêmes
}
