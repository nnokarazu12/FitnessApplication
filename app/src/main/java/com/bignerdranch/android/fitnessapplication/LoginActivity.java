package com.bignerdranch.android.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText usernameField, passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameField = findViewById(R.id.username);
        passwordField = findViewById(R.id.password);
    }

    public void login(View v) {
        SQLiteDbHelper dbHelper = new SQLiteDbHelper(this);
        String user = usernameField.getText().toString();
        String pass = passwordField.getText().toString();
        boolean success = dbHelper.loginSuccess(user, pass);

        if(success) {
            Intent intent = new Intent(LoginActivity.this, SetUpActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_SHORT).show();
        }
    }

}