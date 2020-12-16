package com.bignerdranch.android.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SetUpActivity extends AppCompatActivity {
    EditText weightField, heightField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
    }

    public void setUp(View v) {
        weightField = findViewById(R.id.weight_input);
        heightField = findViewById(R.id.height_input);
        String weightInput = weightField.getText().toString();
        String heightInput = heightField.getText().toString();

        int w = Integer.parseInt(weightInput);
        int h = Integer.parseInt(heightInput);

        double bmiValue = w / Math.pow(h, 2) * 703;

        //Round value to nearest tenths place
        BigDecimal bd = new BigDecimal(Double.toString(bmiValue));
        bd = bd.setScale(1, RoundingMode.HALF_UP);

        double rounderBMIValue = bd.doubleValue();

        Intent intent = new Intent(SetUpActivity.this, UserActivity.class);
        intent.putExtra("BMI", rounderBMIValue);
        startActivity(intent);
    }


}