package com.example.admin.simplesqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin on 8/8/2016.
 */
public class StudentsHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "students.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_USERS = "students";
    public static final String KEY_USER_ID = "id";
    public static final String KEY_USER_NAME = "userName";
    public static final String KEY_AGE = "age";


    public StudentsHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //It is call whenever we first install the application, create the db manually
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS +
                "(" +
                KEY_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_USER_NAME + " TEXT," +
                KEY_AGE + " TEXT" +
                ")";

        sqLiteDatabase.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(sqLiteDatabase);
    }
}
