package com.example.budgetapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class View_Income extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[],s2[],s3[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__income);

        recyclerView = findViewById(R.id.recyclerViewIncome);

        s1 = getResources().getStringArray(R.array.ViewIncome_Items);
        s2 = getResources().getStringArray(R.array.ViewIncome_PriceList);
        s3 = getResources().getStringArray(R.array.ViewIncome_Date);


        ViewIncomeAdapter viewIncomeAdapter = new ViewIncomeAdapter(this, s1 ,s2, s3);
        recyclerView.setAdapter(viewIncomeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}