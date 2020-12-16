package com.bignerdranch.android.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.bignerdranch.android.fitnessapplication.Contract.Entry;



public class SignUpActivity extends AppCompatActivity {
    SQLiteDbHelper dbHelper = new SQLiteDbHelper(this);
    EditText firstnameField, lastnameField, s_usernameField, s_passwordField;
    String firstnameInput, lastnameInput, s_usernameInput, s_passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Get text field reference
        firstnameField = findViewById(R.id.s_firstname);
        lastnameField = findViewById(R.id.s_lastname);
        s_usernameField = findViewById(R.id.s_username);
        s_passwordField = findViewById(R.id.s_password);

    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }

    public void signUp(View v) {
        // Gets the data repository in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //Get input values
        firstnameInput = firstnameField.getText().toString();
        lastnameInput = lastnameField.getText().toString();
        s_usernameInput = s_usernameField.getText().toString();
        s_passwordInput = s_passwordField.getText().toString();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Entry.FIRSTNAME, firstnameInput);
        values.put(Entry.LASTNAME, lastnameInput);
        values.put(Entry.USERNAME, s_usernameInput);
        values.put(Entry.PASSWORD, s_passwordInput);

// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(Entry.TABLE_NAME, null, values);
    }


}