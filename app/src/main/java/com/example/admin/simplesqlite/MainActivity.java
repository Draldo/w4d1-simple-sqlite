package com.example.admin.simplesqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + "TAG_";

    private EditText mName;
    private EditText mAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = (EditText) findViewById(R.id.name_et);
        mAge = (EditText) findViewById(R.id.age_et);

    }

    public void insertDB(View view) {
        StudentsHelper studentsHelper = new StudentsHelper(getApplicationContext());
        SQLiteDatabase db = studentsHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(studentsHelper.KEY_USER_NAME, mName.getText().toString());
        values.put(studentsHelper.KEY_AGE, mAge.getText().toString());

        db.insert(studentsHelper.TABLE_USERS, null, values);

        mName.setText("");
        mAge.setText("");

    }

    public void loadRaw(View view) {
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

    public void loadDB(View view) {
        StudentsHelper studentsHelper = new StudentsHelper(getApplicationContext());
        SQLiteDatabase db = studentsHelper.getReadableDatabase();

        Cursor cursor = db.query(studentsHelper.TABLE_USERS,
                null,
                null,
                null,
                null,
                null,
                null);

        cursor.moveToFirst();

        do{
            int id = cursor.getInt(cursor.getColumnIndex(studentsHelper.KEY_USER_ID));
            String name = cursor.getString(cursor.getColumnIndex(studentsHelper.KEY_USER_NAME));
            String age = cursor.getString(cursor.getColumnIndex(studentsHelper.KEY_AGE));

            Log.d(TAG, "loadDB: " + id + " " + name + " " + age);

        }while(cursor.moveToNext());

    }
}
