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
    private static final String TABLE_NAME = "Shopping_TABLE";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "ELEMENT";
    private static final String COL_3 = "STATUS";
    private static final String COL_4 = "CATEGORY";

    private static final int DATABASE_VERSION = 2;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COL_2 + " TEXT,"
                + COL_3 + " INTEGER,"
                + COL_4 + " TEXT" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertElement(ShoppingListModel model) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, model.getElement());
        contentValues.put(COL_3, 0);
        contentValues.put(COL_4, model.getCategory());
        db.insert(TABLE_NAME, null, contentValues);
    }

    public void updateElement(int id, String element) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, element);
        db.update(TABLE_NAME, contentValues, "ID=?", new String[]{String.valueOf(id)});
    }

    public void updateStatus(int id, int status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_3, status);
        db.update(TABLE_NAME, contentValues, "ID=?", new String[]{String.valueOf(id)});
    }

    public void deleteElement(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "ID=?", new String[]{String.valueOf(id)});
    }

    public List<ShoppingListModel> getAllElements() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        List<ShoppingListModel> shoppingList = new ArrayList<>();

        db.beginTransaction();
        try {
            cursor = db.query(TABLE_NAME, null, null, null, null, null, null); // pas de tri SQL ici
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        ShoppingListModel shoppingListModel = new ShoppingListModel();
                        shoppingListModel.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COL_1)));
                        shoppingListModel.setElement(cursor.getString(cursor.getColumnIndexOrThrow(COL_2)));
                        shoppingListModel.setStatus(cursor.getInt(cursor.getColumnIndexOrThrow(COL_3)));
                        shoppingListModel.setCategory(cursor.getString(cursor.getColumnIndexOrThrow(COL_4)));
                        shoppingList.add(shoppingListModel);
                    } while (cursor.moveToNext());
                }
            }
        } finally {
            db.endTransaction();
            if (cursor != null) cursor.close();
        }

        // si une new category est cree, le rajouter ici (l'ordre est important)
        List<String> categoryOrder = Arrays.asList(
                "Fruits",
                "Vegetables",
                "Meats",
                "Dairy",
                "Grocery",
                "Frozen",
                "maintenance",
                "Personal Care",
                "Autres"
        );

        Collections.sort(shoppingList, new Comparator<ShoppingListModel>() {
            @Override
            public int compare(ShoppingListModel o1, ShoppingListModel o2) {
                int index1 = categoryOrder.indexOf(o1.getCategory());
                int index2 = categoryOrder.indexOf(o2.getCategory());

                if (index1 == -1) index1 = categoryOrder.size();
                if (index2 == -1) index2 = categoryOrder.size();

                if (index1 != index2) {
                    return Integer.compare(index1, index2);
                } else {
                    return o1.getElement().compareToIgnoreCase(o2.getElement());
                }
            }
        });

        Collections.reverse(shoppingList);

        return shoppingList;
    }
}
