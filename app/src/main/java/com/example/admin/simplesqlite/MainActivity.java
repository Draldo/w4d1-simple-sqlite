package com.example.admin.simplesqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + "TAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insertDB(View view) {
        StudentsHelper studentsHelper = new StudentsHelper(getApplicationContext());
        SQLiteDatabase db = studentsHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(studentsHelper.KEY_USER_NAME, "Aldo");
        values.put(studentsHelper.KEY_AGE, "25");

        db.insert(studentsHelper.TABLE_USERS, null, values);

    }

    public void loadDB(View view) {
        StudentsHelper studentsHelper = new StudentsHelper(getApplicationContext());
        SQLiteDatabase db = studentsHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + studentsHelper.TABLE_USERS, null);

        cursor.moveToFirst();

        do{
            int id = cursor.getInt(cursor.getColumnIndex(studentsHelper.KEY_USER_ID));
            String name = cursor.getString(cursor.getColumnIndex(studentsHelper.KEY_USER_NAME));
            String age = cursor.getString(cursor.getColumnIndex(studentsHelper.KEY_AGE));

            Log.d(TAG, "loadDB: " + id + " " + name + " " + age);

        }while(cursor.moveToNext());

    }
}
