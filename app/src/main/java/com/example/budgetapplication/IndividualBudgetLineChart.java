package com.example.budgetapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.budgetapplication.Models.IndividualBudgetModel;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
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

public class IndividualBudgetLineChart extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;

    LineChart individualBudgetBarchart;
    LineDataSet lineDataSet = new LineDataSet(null,null);
    ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
    LineData lineData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);

        individualBudgetBarchart = (LineChart) findViewById(R.id.individualBarChart);
        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference("IndividualBudget");

        individualBudgetBarchart.setData(lineData);
        individualBudgetBarchart.invalidate();
        retriveData();

    }

    public void retriveData() {
       // final ArrayList<BarEntry> dataVAls = new ArrayList<BarEntry>();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Entry> dataVAls = new ArrayList<Entry>();
                if(dataSnapshot.hasChildren()){
                    for (DataSnapshot myDatasnapShot : dataSnapshot.getChildren()){
                        IndividualBudgetModel individualBudgetModel = myDatasnapShot.getValue(IndividualBudgetModel.class);
                        String date = individualBudgetModel.getIndividualBudgetBalance();
                        int amunt =Integer.parseInt(individualBudgetModel.getIndividualTotalBudgetAmount());
                        dataVAls.add(new Entry(Float.parseFloat(date),amunt));
                    }
                    showChart(dataVAls);
                }else
                   individualBudgetBarchart.clear();
               individualBudgetBarchart.invalidate();

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
    private void showChart(ArrayList<Entry> dataVAls) {
        lineDataSet.setValues(dataVAls);
        lineDataSet.setLabel("Individual Budget");
        lineDataSet.setColor(Color.RED);
        lineDataSet.setLineWidth(3f);
        iLineDataSets.clear();
        iLineDataSets.add(lineDataSet);
        lineData = new LineData(iLineDataSets);
        individualBudgetBarchart.clear();
        individualBudgetBarchart.setData(lineData);
        individualBudgetBarchart.invalidate();
    }
}