package com.example.carl.stockit.Persistance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by carl on 27/03/16.
 */

public class SQLiteStorageServiceImpl  {
    private final ProduitOpenHelper produitOpenHelper;

    public SQLiteStorageServiceImpl(Context context) {
        produitOpenHelper = new ProduitOpenHelper(context);
    }


    public List<String> store(Context context, List<String> produits) {
        clear(context);
        SQLiteDatabase db = null;
        try{db = produitOpenHelper.getWritableDatabase();
            ContentValues insertValues = null;
            for(String produit : produits){
                insertValues = new ContentValues();
                insertValues.put(ProduitOpenHelper.PRODUIT_COL_NAME,produit);
                db.insert(ProduitOpenHelper.PRODUIT_TABLE_NAME,null,insertValues);
            }
            return restore(context);
        } finally {
            closeDB(db);
        }
    }



    public List<String> restore(Context context) {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = produitOpenHelper.getReadableDatabase();
            cursor = db.query(ProduitOpenHelper.PRODUIT_TABLE_NAME, new String[]{ProduitOpenHelper.PRODUIT_COL_NAME}, null, null, null, null, ProduitOpenHelper.PRODUIT_COL_NAME);
            List<String> elements = new ArrayList<>();
            while (cursor.moveToNext()) {
                elements.add(cursor.getString(0));
            }
            cursor.close();
            return elements;
        } finally {
            closeDB(db, cursor);
        }
    }

    public List<String> clear(Context context) {
        SQLiteDatabase db = null;
        try {
            db = produitOpenHelper.getWritableDatabase();
            db.delete(ProduitOpenHelper.PRODUIT_TABLE_NAME, null, null);
            return restore(context);
        } finally {
            closeDB(db);
        }
    }

    public void add(Context context, String produit,int qtite) {
        SQLiteDatabase db = null;
        try {
            db = produitOpenHelper.getWritableDatabase();
            ContentValues insertValues = new ContentValues();
            insertValues.put(ProduitOpenHelper.PRODUIT_COL_NAME, produit);
            insertValues.put(ProduitOpenHelper.PRODUIT_COL_QTITE,qtite);
            long rowId = db.insert(ProduitOpenHelper.PRODUIT_TABLE_NAME, null, insertValues);
        } finally {
            closeDB(db);
        }

    }
    private void closeDB(Closeable... elementsToClose) {
        for (Closeable elementToClose : elementsToClose) {
            if (null != elementToClose) {
                try {
                    elementToClose.close();
                } catch (IOException e) {
                    Log.e("StockIt", "Impossible to close element ", e);
                }
            }
        }
    }
}
