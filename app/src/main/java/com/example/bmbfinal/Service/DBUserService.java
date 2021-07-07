package com.example.bmbfinal.Service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bmbfinal.Model.UserModel;

public class DBUserService extends SQLiteOpenHelper {

    public DBUserService(Context context) {
        super(context, "UserData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Users(ID INTEGER primary key autoincrement, Email text, Password text)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Users");

    }

    public Boolean InsertUser(UserModel userModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Email", userModel.getEmail());
        contentValues.put("Password", userModel.getPassword());

        long resutl = db.insert("Users", null, contentValues);
        if (resutl == -1)
            return false;
        else
            return true;
    }

    public Boolean UpdateUser(UserModel userModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Email", userModel.getEmail());
        contentValues.put("Password", userModel.getPassword());

        Cursor cursor = db.rawQuery("select * from UserDetails where Email=?", new String[]{userModel.getEmail()});

        if (cursor.getCount() > 0) {
            long resutl = db.update("UserDetails", contentValues, "Email=?", new String[]{userModel.getEmail()});
            if (resutl == -1)
                return false;
            else
                return true;
        } else {
            return false;
        }
    }

    public Boolean DeleteUser(UserModel userModel) {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from UserDetails where ID=?", new String[]{userModel.getID().toString()});

        if (cursor.getCount() > 0) {
            long resutl = db.delete("UserDetails", "name=?", new String[]{userModel.getID().toString()});
            if (resutl == -1)
                return false;
            else
                return true;
        } else {
            return false;
        }
    }

    public Cursor GetUserData() {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from Users", null);

        return cursor;
    }

    public Boolean LoginUser(UserModel userModel) {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from Users where Email=? and Password=?", new String[]{userModel.getEmail(),userModel.getPassword()});

        if (cursor.getCount()==1)
            return true;
        else
            return false;
    }

}