package com.example.budgetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BudgetCharts extends AppCompatActivity {
    Button btn1,btn2,btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_charts);

        btn1 = findViewById(R.id.ichart);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(BudgetCharts.this,IndividualBudgetLineChart.class);
                startActivity(intent);
            }
        });

        btn2 = findViewById(R.id.fchart);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(BudgetCharts.this,FamilyBudgetLineChart.class);
                startActivity(intent);
            }
        });

        btn3 = findViewById(R.id.echart);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(BudgetCharts.this,EventBudgetLineChart.class);
                startActivity(intent);
            }
        });
    }
}