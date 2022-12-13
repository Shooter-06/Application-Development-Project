package com.example.final_project.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.final_project.ToDo.Logins;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperRegister extends SQLiteOpenHelper {

    public static final String DB_NAME = "account.db";
    public static final int DB_VERSION = 1;
    //ContentValues contentValues= new ContentValues();


    public DatabaseHelperRegister(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table account(fname varchar,lname varchar,password varchar,confpassw varchar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists account");
        onCreate(db);
    }
    public Boolean insert(String fname,String lname, String pass,String cpass){
        SQLiteDatabase db= getWritableDatabase();
        ContentValues v=new ContentValues();
        v.put("fname",fname);
        v.put("lname",lname);
        v.put("password",pass);
        v.put("confpassw",cpass);
        db.insert("account",null,v);
        db.close();
        return true;
    }
    public Cursor viewAllProduct() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(" select * from account", null);
        return  res;
    }
    public boolean CheckUsername(String fname){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cur=db.rawQuery("select * from account where fname=?", new String[] {fname});
        if(cur.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean CheckUsernamePassword(String fname, String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cur=db.rawQuery("select * from account where fname=? and password=?", new String[] {fname,password});
        if(cur.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
    public Boolean read(String fname,String lname,String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("select * from account where fname=? and lname=? and password=?", new String[]{fname, lname, password});
        if (cur.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public List<Logins> getUserLogins() {
        SQLiteDatabase db= getWritableDatabase();

        List<Logins> list= new ArrayList<>();
        Cursor cursor =db.rawQuery(" select * from account" , null);
        Logins login = new Logins();

        if (cursor.moveToFirst()) {
            do {

                list.add(login=new Logins(cursor.getString(0) , cursor.getString(1),  cursor.getString(2),cursor.getString(3)));
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return list;
    }

    public Integer deleteProduct (String username)  {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("account", " username = ? ", new String[] {username});
    }
}
