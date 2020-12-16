package com.bignerdranch.android.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {
    TextView bmiText;
    SQLiteDbHelper dbHelper = new SQLiteDbHelper(this);
    TextView firstname;
    TextView newGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        double bmi = getIntent().getDoubleExtra("BMI", 0.0);
        bmiText = findViewById(R.id.bmi_text);
        bmiText.setText(String.valueOf(bmi));

        firstname = findViewById(R.id.firstname);
        firstname.setText(dbHelper.getFirstName("admin", "admin"));

        Intent intent = getIntent();
        String goal = intent.getStringExtra("WEIGHT_GOAL");
        newGoal = findViewById(R.id.new_goal);
        newGoal.setText(goal);

    }

    public void addGoal(View v) {
        Intent intent = new Intent(UserActivity.this, AddGoalActivity.class);
        startActivity(intent);
    }
}