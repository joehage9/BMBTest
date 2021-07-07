package com.example.bmbfinal.Service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bmbfinal.Model.OrderModel;
import com.example.bmbfinal.Model.UserModel;

public class DBOrdersService extends SQLiteOpenHelper {

    public DBOrdersService(Context context) {
        super(context, "UserData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table Orders(" +
                "ID INTEGER primary key autoincrement, " +
                "OrderAmount INTEGER," +
                "OrderDate date," +
                "ClientID INTEGER," +
                "Description text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Orders");

    }

    public Boolean InsertOrder(OrderModel orderModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("OrderAmount", orderModel.getOrderAmount());
        contentValues.put("OrderDate", orderModel.getOrderDate().toString());
        contentValues.put("ClientID", orderModel.getClientID());
        contentValues.put("Description", orderModel.getDescription());

        long resutl = db.insert("Orders", null, contentValues);
        if (resutl == -1)
            return false;
        else
            return true;
    }

    public Boolean UpdateOrder(OrderModel orderModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("ID", orderModel.getId());
        contentValues.put("OrderAmount", orderModel.getOrderAmount());
        contentValues.put("OrderDate", orderModel.getOrderDate().toString());
        contentValues.put("ClientID", orderModel.getClientID());
        contentValues.put("Description", orderModel.getDescription());

        Cursor cursor = db.rawQuery("select * from Orders where ID=?", new String[]{orderModel.getId().toString()});

        if (cursor.getCount() > 0) {
            long resutl = db.update("Orders", contentValues, "ID=?", new String[]{orderModel.getId().toString()});
            if (resutl == -1)
                return false;
            else
                return true;
        } else {
            return false;
        }
    }

    public Boolean DeleteOrder(OrderModel orderModel) {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from Orders where ID=?", new String[]{orderModel.getId().toString()});

        if (cursor.getCount() > 0) {
            long resutl = db.delete("Orders", "ID=?", new String[]{orderModel.getId().toString()});
            if (resutl == -1)
                return false;
            else
                return true;
        } else {
            return false;
        }
    }

    public Cursor GetOrderData(Integer clientID) {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from Orders where ClientID=?", new String[]{clientID.toString()});
        return cursor;
    }

}