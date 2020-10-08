package com.example.budgetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Expenses extends AppCompatActivity {

     Button btn,btn01,btn02,btn03;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);



        btn01 = findViewById(R.id.AddToExpense);
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Expenses.this, AddToBudgetTab.class);
                startActivity(intent);
            }
        });

        btn02 = findViewById(R.id.ViewExpense);
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Expenses.this, viewExpense.class);
                startActivity(intent);
            }
        });



    }
}