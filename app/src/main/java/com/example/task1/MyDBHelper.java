package com.example.task1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DbNAMe = "contects_database";
    private static final int dbVersion = 1;

    public MyDBHelper(Context context) {

        super(context, DbNAMe, null, dbVersion);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "create table user_contect (id integer primary key autoincrement ,name text,email text" + ",mobile text)";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("drop table if exists user_contect");
        onCreate(db);
    }

    public boolean insertcontact(String name, String email, String mobile) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("Name", name);
        values.put("Email", email);
        values.put("Mobile", mobile);
        long r = db.insert("user_contect", null, values);

        if (r != 1) return true;
        else return false;

    }

    public boolean updatecontact(String name, String email, String mobile) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name", name);
        values.put("Email", email);
        values.put("Mobile", mobile);
        Cursor cursor = db.rawQuery("select * from user_contect where name=?", new String[]{name});
        if (cursor.getCount() > 0) {
            long u = db.update("user_contect", values, "name=?", new String[]{name});
            if (u == -1) {
                    return  false;
            }
            else
            {
                return true;
            }

        } else {
            return true;

        }
    }

    public boolean deletcontact(String name)
    {
        SQLiteDatabase db= getWritableDatabase();
        Cursor cursor =db.rawQuery("select * from user_contect where name=? ",new String[]{name});
        if (cursor.getCount()>0)
        {
            long d=db.delete("user_contect","name=?",new String[]{name});
            if (d==-1)
            {
                return false;

            }
            else
            {
                return true;
            }

        }
        else
        {
            return false;
        }
    }

    public Cursor showdata() {
        SQLiteDatabase db = getWritableDatabase();
        String query = "Select * From user_contect";
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }


}



