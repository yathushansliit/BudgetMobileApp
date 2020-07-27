package com.example.budgetapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class viewExpense extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[],s2[],s3[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_expense);

        recyclerView = findViewById(R.id.recyclerViewExpense);

        s1 = getResources().getStringArray(R.array.ViewExpense_Items);
        s2 = getResources().getStringArray(R.array.ViewExpense_PriceList);
        s3 = getResources().getStringArray(R.array.ViewExpense_Date);

        ViewExpenseAdapter viewExpenseAdapter = new ViewExpenseAdapter(this, s1 ,s2, s3);
        recyclerView.setAdapter(viewExpenseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}