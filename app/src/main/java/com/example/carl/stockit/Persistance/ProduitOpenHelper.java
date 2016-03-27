package com.example.carl.stockit.Persistance;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by carl on 26/03/16.
 */
public class ProduitOpenHelper extends SQLiteOpenHelper {
public static final String DATABASE_NAME = "PRODUIT_DB";
    public static final int DATABASE_VERSION = 1;
    public static final String PRODUIT_TABLE_NAME = "produits";
    public static final String PRODUIT_COL_NAME = "name";
    private static final String TABLES_CREATE = "CREATE TABLE " + PRODUIT_TABLE_NAME + " (" + PRODUIT_COL_NAME +" TEXT);";
    public ProduitOpenHelper(Context context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLES_CREATE);
    }


    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
