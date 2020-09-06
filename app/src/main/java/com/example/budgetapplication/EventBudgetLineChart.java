package com.example.budgetapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.budgetapplication.Models.EventBudgetModel;
import com.example.budgetapplication.Models.FamilyBudgetModel;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EventBudgetLineChart extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;

    LineChart eventBudgetBarchart;
    LineDataSet lineDataSet = new LineDataSet(null,null);
    ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
    LineData lineData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_budget_line_chart);

        eventBudgetBarchart = (LineChart) findViewById(R.id.eventLineChart);
        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference("EventBudget");

        eventBudgetBarchart.setData(lineData);
        eventBudgetBarchart.invalidate();
        retriveData();
    }

    private void retriveData() {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Entry> dataVAls = new ArrayList<Entry>();
                if(dataSnapshot.hasChildren()){
                    for (DataSnapshot myDatasnapShot : dataSnapshot.getChildren()){
                        EventBudgetModel eventBudgetModel = myDatasnapShot.getValue(EventBudgetModel.class);
                        String date = eventBudgetModel.getEventExpenseAmount();
                        int amunt =Integer.parseInt(eventBudgetModel.getEventTotalBudgetAmount());
                        dataVAls.add(new Entry(Float.parseFloat(date),amunt));
                    }
                    showChart(dataVAls);
                }else
                    eventBudgetBarchart.clear();
                eventBudgetBarchart.invalidate();

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void showChart(ArrayList<Entry> dataVAls) {
        lineDataSet.setValues(dataVAls);
        lineDataSet.setLabel("Event Budget");
        lineDataSet.setColor(Color.RED);
        lineDataSet.setLineWidth(3f);
        iLineDataSets.clear();
        iLineDataSets.add(lineDataSet);
        lineData = new LineData(iLineDataSets);
        eventBudgetBarchart.clear();
        eventBudgetBarchart.setData(lineData);
        eventBudgetBarchart.invalidate();
    }

}