package com.example.budgetapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class IndividualListView extends AppCompatActivity {


    RecyclerView recyclerView;
    String s1[], s2[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_list_view);

        recyclerView = findViewById(R.id.recyclerIndividual);
        s1 = getResources().getStringArray(R.array.Individual_Items);
        s2 = getResources().getStringArray(R.array.Individual_PriceList);

        IndividualAdapter individualAdapter = new IndividualAdapter(this, s1, s2);
        recyclerView.setAdapter(individualAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}