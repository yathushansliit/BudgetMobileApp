package com.example.budgetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BudgetHistory extends AppCompatActivity {

    Button button,button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_history2);


        button = findViewById(R.id.BudgetHistoryListView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(BudgetHistory.this,BudgetHistoryListView.class);
                startActivity(intent);
            }
        });


        button1 = findViewById(R.id.BudgetHistoryCHartView);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent(BudgetHistory.this,BudgetCharts.class);
                startActivity(intent2);
            }
        });


    }
}