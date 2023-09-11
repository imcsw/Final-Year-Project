package com.example.fyp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    //public static final String DBNAME = "Login.db";
    public static final String DBNAME = "fypApp.db";
    public DBHelper(Context context) {
        super(context, "fypApp.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        MyDB.execSQL("create Table attendance(studentID TEXT primary key not null, subjectCode TEXT not null, " +
                "classroomNo INT not null, phoneNo TEXT not null, code INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists attendance");
    }

    public Boolean insertUserData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean insertAttendanceData(String studentID, String subjectCode, int classroomNo, String phoneNo, int code){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("studentID", studentID);
        contentValues.put("subjectCode", subjectCode);
        contentValues.put("classroomNo", classroomNo);
        contentValues.put("phoneNo", phoneNo);
        contentValues.put("code", code);
        long result = MyDB.insert("attendance", null, contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkID(String studentID) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from attendance where studentID = ?", new String[]{studentID});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkPhoneNo(String phoneNo){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from attendance where phoneNo = ?", new String[] {phoneNo});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkCode(String phoneNo, int code){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from attendance where phoneNo = ? and code = ?", new String[] {phoneNo ,Integer.toString(code).trim()});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    // after verifying the code, delete record from table
    public void codeVerified(String phoneNumber){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.execSQL("Delete from attendance where phoneNo = ?", new String[]{phoneNumber});
    }

    public int getCode(String phoneNo){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        int tfaCode = 0;
        Cursor cursor = MyDB.rawQuery("Select code from attendance where phoneNo = ?", new String[]{phoneNo});
        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            tfaCode = cursor.getInt(0);
            return tfaCode;
        }
        else
            return tfaCode;
    }
}