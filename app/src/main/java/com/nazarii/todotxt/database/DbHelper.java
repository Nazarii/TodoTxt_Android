package com.nazarii.todotxt.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.nazarii.todotxt.database.Contract.TodoItem;

/**
 * Created by nazik on 21.12.15.
 */
public class DbHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "TodoTxt.db";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_EVENT_TABLE = "CREATE TABLE " + TodoItem.TABLE_NAME + " (" +
                TodoItem._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                TodoItem.COLUMN_STATUS + " BOOLEAN," +
                TodoItem.COLUMN_NAME + " TEXT NOT NULL ON CONFLICT REPLACE);";
        sqLiteDatabase.execSQL(SQL_CREATE_EVENT_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TodoItem.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
