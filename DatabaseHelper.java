package com.example.buspasssystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String Database_Name="Register.db";
    public static final String TABLE_NAME = "register_table";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "AGE";
    public static final String COL_3 = "PRN";
    public static final String COL_4 = "EMAIL";
    public static final String COL_5 = "PWD";
    public static final String COL_6 = "CLG";


    public DatabaseHelper(@Nullable Context context){

        super(context,Database_Name,null,1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(NAME TEXT, " +
                "AGE INTEGER, " +
                "CLG TEXT," +
                "PRN INTEGER PRIMARY KEY, " +
                "EMAIL TEXT, " +
                "PWD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate(db);
    }

    public boolean insertData(String name, String age, String scl, String prn, String email, String pwd){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,age);
        contentValues.put(COL_3,scl);
        contentValues.put(COL_4,prn);
        contentValues.put(COL_5,email);
        contentValues.put(COL_6,pwd);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
        {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " +TABLE_NAME, null);
        return res;
    }


}
