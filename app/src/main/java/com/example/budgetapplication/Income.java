package com.example.budgetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Income extends AppCompatActivity {

    Button button, button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        button = findViewById(R.id.AddIncome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Income.this, AddIncome.class);
                startActivity(intent1);
            }
        });

        button1 = findViewById(R.id.ViewIncome);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Income.this, View_Income.class);
                startActivity(intent);
            }
        });
    }
}