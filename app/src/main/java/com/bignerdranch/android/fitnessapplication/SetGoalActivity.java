package com.bignerdranch.android.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SetGoalActivity extends AppCompatActivity {
    private static final String WEIGHT_GOAL = "WEIGHT_GOAL";
    EditText goal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goal);
    }

    public void setGoal(View v) {
        goal = findViewById(R.id.goal);
        String g = "Lose " + goal.getText().toString() + "lbs";
        Intent intent = new Intent(SetGoalActivity.this, UserActivity.class);
        intent.putExtra(WEIGHT_GOAL, g);
        startActivity(intent);
    }


}