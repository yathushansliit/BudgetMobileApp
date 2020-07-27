package com.example.budgetapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class eventListView extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[],s2[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list_view);

        recyclerView = findViewById(R.id.recyclerEvent);
        s1 = getResources().getStringArray(R.array.Event_Items);
        s2 = getResources().getStringArray(R.array.Event_PriceList);

        EventAdapter eventAdapter = new EventAdapter(this, s1, s2);
        recyclerView.setAdapter(eventAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}