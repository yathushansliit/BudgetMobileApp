package com.example.budgetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddtoBudgetExpense extends AppCompatActivity {

    Button btn01,btn02,btn03,btn04,btn05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addto_budget_expense);

        btn01 = findViewById(R.id.IndividualEx);
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddtoBudgetExpense.this, BudgetHistory.class);
                startActivity(intent);
            }
        });



        btn02 = findViewById(R.id.FamilyEx);
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddtoBudgetExpense.this, BudgetHistory.class);
                startActivity(intent);
            }
        });

        btn03 = findViewById(R.id.ReunionEx);
        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddtoBudgetExpense.this, BudgetHistory.class);
                startActivity(intent);
            }
        });

        btn04 = findViewById(R.id.BirthdayEx);
        btn04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddtoBudgetExpense.this, BudgetHistory.class);
                startActivity(intent);
            }
        });

        btn05 = findViewById(R.id.farewellEx);
        btn05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddtoBudgetExpense.this, BudgetHistory.class);
                startActivity(intent);
            }
        });
    }
}