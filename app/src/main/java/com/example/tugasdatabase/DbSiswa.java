package com.example.tugasdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbSiswa extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "siswa.db";
    private static final int DATABASE_VERSION = 1;
    public static final String table_people = "students";
    private static final String key_id = "id";
    public static final String key_name = "nama";

    private static final String create_table_people = "CREATE TABLE " + table_people + " (" +
        key_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
        key_name + " TEXT);";

    public DbSiswa(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_table_people);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_people);
        onCreate(db);
    }
}