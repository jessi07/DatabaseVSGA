package com.example.tugasdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DbSiswa dbSiswa;
    private EditText nama;
    private TextView ouput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = findViewById(R.id.namasiswa);
        ouput = findViewById(R.id.ouputnama);
        dbSiswa = new DbSiswa(this);
    }

    public void insert(View view) {
        String name = nama.getText().toString();

        SQLiteDatabase db = dbSiswa.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DbSiswa.key_name, name);
        long id = db.insert(DbSiswa.table_people, null, values);
        Log.d("Database", "Id data: " + id);
    }

    public void read(View view) {

        ArrayList<String> data = new ArrayList<>();

        SQLiteDatabase db = dbSiswa.getReadableDatabase();
        String query = "SELECT * FROM " + DbSiswa.table_people;
        Cursor j = db.rawQuery(query,   null);
        while(j.moveToNext()){
                data.add(j.getString(j.getColumnIndex(DbSiswa.key_name)));
        }
        j.close();

        ouput.setText("");
        for (int i = 0; i < data.size(); i++) {
            ouput.setText(ouput.getText().toString() + "\n" + data.get(i));
        }
    }
}