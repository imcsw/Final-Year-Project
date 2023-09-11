package com.example.fyp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAttendanceHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "attendance.db";
    public DBAttendanceHelper(Context context) {
        super(context, "attendance.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table attendance(studentID TEXT primary key not null, subjectCode TEXT not null, " +
                    "classroomNo INT not null, phoneNo TEXT not null, code INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists attendance");
    }

    public Boolean insertData(String studentID, String subjectCode, int classroomNo, String phoneNo, int code){
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
    public void codeVerified(String studentID){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.execSQL("Delete from attendance where studentID = ?", new String[]{studentID});
    }

    public int getCode(String phoneNo){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        int tfaCode = 0;
        Cursor cursor = MyDB.rawQuery("Select code from attendance where studentID = ?", new String[]{phoneNo});
        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            tfaCode = cursor.getInt(0);
            return tfaCode;
        }
        else
            return tfaCode;
    }
}