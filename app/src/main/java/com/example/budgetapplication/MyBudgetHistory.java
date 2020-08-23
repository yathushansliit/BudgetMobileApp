package com.example.budgetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MyBudgetHistory extends AppCompatActivity {
    Button btnIndividual,btnFamily,btnEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_budget_history);

        btnIndividual = findViewById(R.id.individualBudget);
        btnIndividual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyBudgetHistory.this,IndividualBudgetHistoryListView.class);
                startActivity(intent);
            }
        });

        btnFamily = findViewById(R.id.familyBudget);
        btnFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyBudgetHistory.this,FamilyBudgetHistoryListView.class);
                startActivity(intent);
            }
        });

        btnEvent = findViewById(R.id.eventBudget);
        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyBudgetHistory.this,EventBudgetHistoryListView.class);
                startActivity(intent);
            }
        });

    }
}