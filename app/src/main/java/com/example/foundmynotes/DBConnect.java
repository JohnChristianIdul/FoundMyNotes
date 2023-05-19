package com.example.foundmynotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConnect extends SQLiteOpenHelper {

    public DBConnect(Context context) {
        super(context, "user_data.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table user(email_address TEXT primary key, password TEXT, Name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists user");
    }

    // used for sign up
    public boolean insertUserData(String email_address, String password, String name){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email_address", email_address);
        contentValues.put("password", password);
        contentValues.put("name", name);
        long result = DB.insert("user", null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

// can be use for update profile
    public boolean updateUserData(String email_address, String password, String name){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email_address", email_address);
        contentValues.put("password", password);
        contentValues.put("name", name);
        Cursor cursor = DB.rawQuery("select * from user where name = ?", new String[] {name});
        if(cursor.getCount()>0) {
            long result = DB.update("user", contentValues, "name=?", new String[] {name});
            if(result == -1)
                return false;
            else
                return true;
        }else {
            return false;
        }
    }

//can be used for delete account
    public boolean deleteUserData(String email_address, String password, String name){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from user where name = ?", new String[] {name});
        if(cursor.getCount()>0) {
            long result = DB.delete("user", "name=?", new String[] {name});
            if(result == -1)
                return false;
            else
                return true;
        }else {
            return false;
        }
    }

    //used for log in
    public Boolean getUserData(String email, String password){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from user where email_address=? and password =?", new String[] {email, password});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }
}
