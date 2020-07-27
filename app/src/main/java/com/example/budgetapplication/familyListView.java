package com.example.budgetapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class familyListView extends AppCompatActivity {

    RecyclerView recyclerView;
    String s1[], s2[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_list_view);

        recyclerView = findViewById(R.id.recyclerFamily);
        s1 = getResources().getStringArray(R.array.Family_Items);
        s2 = getResources().getStringArray(R.array.Family_PriceList);

        FamilyAdapter familyAdapter = new FamilyAdapter(this, s1, s2);
        recyclerView.setAdapter(familyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}