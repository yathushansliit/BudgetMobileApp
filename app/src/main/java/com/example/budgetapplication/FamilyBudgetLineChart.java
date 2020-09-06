package com.example.budgetapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.budgetapplication.Models.FamilyBudgetModel;
import com.example.budgetapplication.Models.IndividualBudgetModel;
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

public class FamilyBudgetLineChart extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;

    LineChart familyBudgetBarchart;
    LineDataSet lineDataSet = new LineDataSet(null,null);
    ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
    LineData lineData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_budget_line_chart);

        familyBudgetBarchart = (LineChart) findViewById(R.id.familyLineChart);
        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference("FamilyBudget");

        familyBudgetBarchart.setData(lineData);
        familyBudgetBarchart.invalidate();
        retriveData();



    }

    private void retriveData() {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Entry> dataVAls = new ArrayList<Entry>();
                if(dataSnapshot.hasChildren()){
                    for (DataSnapshot myDatasnapShot : dataSnapshot.getChildren()){
                        FamilyBudgetModel familyBudgetModel = myDatasnapShot.getValue(FamilyBudgetModel.class);
                        String date = familyBudgetModel.getFamilyBudgetBalance();
                        int amunt =Integer.parseInt(familyBudgetModel.getFamilyTotalBudgetAmount());
                        dataVAls.add(new Entry(Float.parseFloat(date),amunt));
                    }
                    showChart(dataVAls);
                }else
                    familyBudgetBarchart.clear();
                    familyBudgetBarchart.invalidate();
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void showChart(ArrayList<Entry> dataVAls) {
        lineDataSet.setValues(dataVAls);
        lineDataSet.setLabel("Family Budget");
        lineDataSet.setColor(Color.RED);
        lineDataSet.setLineWidth(3f);
        iLineDataSets.clear();
        iLineDataSets.add(lineDataSet);
        lineData = new LineData(iLineDataSets);
        familyBudgetBarchart.clear();
        familyBudgetBarchart.setData(lineData);
        familyBudgetBarchart.invalidate();

    }
}