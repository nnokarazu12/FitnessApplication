package com.bignerdranch.android.fitnessapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bignerdranch.android.fitnessapplication.Contract.Entry;

public class SQLiteDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "fitnessapp.db";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Entry.TABLE_NAME + " (" +
                    Entry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    Entry.FIRSTNAME + " TEXT," +
                    Entry.LASTNAME + " TEXT," +
                    Entry.USERNAME + " TEXT," +
                    Entry.PASSWORD + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Entry.TABLE_NAME;

    public SQLiteDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public boolean loginSuccess(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select _id from Users where Username=?" +
                "and Password=?", new String[] {username, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public String getFirstName(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {
                Entry.FIRSTNAME
        };
        Cursor cursor = db.query(
                Entry.TABLE_NAME,
                projection,
                "Username=? and Password=?",
                new String[]{username, password},
                null,
                null,
                null
        );
        cursor.moveToNext();
        int firstNameColumnIndex = cursor.getColumnIndex(Entry.FIRSTNAME);
        return cursor.getString(firstNameColumnIndex);
    }
}
