package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Hunter.db";
    public static final String TABLE_NAME = "hunter_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "HUNTERNAME";
    public static final String COL_3 = "HR";
    public static final String COL_4 = "MR";
    public static final String COL_5 = "FAVOURITE_WEAPON";
    public static final String COL_6 = "FAVOURITE_MONSTER";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, HUNTERNAME STRING, HR INTEGER, MR INTEGER, FAVOURITE_WEAPON STRING, FAVOURITE_MONSTER STRING)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }

    public boolean InsertData(String Name, String Hr, String Mr, String Weapon, String Monster){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COL_2, Name);
        cv.put(COL_3, Hr);
        cv.put(COL_4, Mr);
        cv.put(COL_5, Weapon);
        cv.put(COL_6, Monster);

        long Result = db.insert(TABLE_NAME, null, cv);

        if (Result == -1)
            return false;
        else
            return true;
    }

    public Cursor ShowData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor Result = db.rawQuery("select * from " + TABLE_NAME, null);
        return Result;
    }

    public boolean UpdateData(String Id, String Name, String Hr, String Mr, String Weapon, String Monster) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COL_1, Id);
        cv.put(COL_2, Name);
        cv.put(COL_3, Hr);
        cv.put(COL_4, Mr);
        cv.put(COL_5, Weapon);
        cv.put(COL_6, Monster);

        db.update(TABLE_NAME, cv, "ID = ?", new String[] { Id });

        return true;
    }

    public Integer DeleteData(String Id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] { Id });
    }
}
