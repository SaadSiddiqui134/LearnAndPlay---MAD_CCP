package com.example.mad_ccp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "database_ccp";
    private static final int DATABASE_VERSION = 1;

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table1 = "CREATE TABLE std (std_id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, std_name TEXT NOT NULL, std_age INT);";
        db.execSQL(table1);

        String table2 = "CREATE TABLE parent (p_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, p_name TEXT NOT NULL, p_email TEXT, std_id INTEGER, FOREIGN KEY (std_id) REFERENCES std(std_id));";
        db.execSQL(table2);

        String table3 = "CREATE TABLE reward (reward_id INTEGER PRIMARY KEY AUTOINCREMENT, reward_amount INT, reward_activity TEXT, std_id INTEGER, p_id INTEGER, FOREIGN KEY (std_id) REFERENCES std(std_id), FOREIGN KEY (p_id) REFERENCES parent(p_id));";
        db.execSQL(table3);

        String table4 = "CREATE TABLE feedback (feedback_id INTEGER PRIMARY KEY AUTOINCREMENT, feeback_desc TEXT);";
        db.execSQL(table4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS std");
        db.execSQL("DROP TABLE IF EXISTS parent");
        db.execSQL("DROP TABLE IF EXISTS reward");
        db.execSQL("DROP TABLE IF EXISTS feeback");

        onCreate(db);
    }

    // Function to register a student
    public void registerStd(String name, int age) {
        ContentValues valuesStd = new ContentValues();
        valuesStd.put("std_name", name);
        valuesStd.put("std_age", age);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("std", null, valuesStd);
        db.close();
    }

    // Function to register a parent
    public void registerParent(String p_name, String p_email, int std_id) {
        ContentValues valuesParent = new ContentValues();
        valuesParent.put("p_name", p_name);
        valuesParent.put("p_email", p_email);
        valuesParent.put("std_id", std_id);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("parent", null, valuesParent);
        db.close();
    }



    // Function to add a feeback
    public void registerFeedback(String feedback) {
        ContentValues valuesParent = new ContentValues();
        valuesParent.put("feedback_desc", feedback);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("feedback", null, valuesParent);
        db.close();
    }

    // Function to add a reward
    public void addReward(int reward_amount, String reward_activity, int std_id, int p_id) {
        ContentValues valuesReward = new ContentValues();
        valuesReward.put("reward_amount", reward_amount);
        valuesReward.put("reward_activity", reward_activity);
        valuesReward.put("std_id", std_id);
        valuesReward.put("p_id", p_id);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("reward", null, valuesReward);
        db.close();
    }

    public int loginStd(String studentName) {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM std WHERE std_name = ?";
        Cursor cursor = db.rawQuery(query, new String[]{studentName});
        if (cursor.moveToFirst()) {
            cursor.close();
            return 1;  // Student found
        } else {
            cursor.close();
            return 0;  // Student not found
        }
    }

    public int loginParent(String p_name, String student_id) {
        int result = 0;
        String[] str = new String[2];
        str[0] = p_name;
        str[1]= student_id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM parent WHERE p_name=? AND std_id =?", str);
        if (c.moveToFirst()) {
            result = 1;
        }
        c.close();
        return result;
    }

//    public int rewardUpdate(String p_name, String student_id) {
//        int result = 0;
//        String[] str = new String[2];
//        str[0] = p_name;
//        str[1]= student_id;
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor c = db.rawQuery("SELECT * FROM users WHERE username=? AND std_id =?", str);
//        if (c.moveToFirst()) {
//            result = 1;
//        }
//        c.close();
//        return result;
//    }


}
