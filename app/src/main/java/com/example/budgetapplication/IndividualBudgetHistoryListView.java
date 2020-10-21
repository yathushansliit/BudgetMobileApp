package com.example.budgetapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.budgetapplication.Models.IndividualBudgetModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class IndividualBudgetHistoryListView extends AppCompatActivity {
    View v;
    private RecyclerView myreclerview;
    private List<IndividualBudgetModel> individualBudgetModelList;
    private FirebaseRecyclerAdapter<IndividualBudgetModel,RecyclerViewAdapterBhIndividual> adapter;
    private DatabaseReference databaseReference;
    private FirebaseRecyclerOptions<IndividualBudgetModel> options;

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_budget_history_list_view);

        myreclerview = findViewById(R.id.myRecyclerIndividualBH);
        myreclerview.setHasFixedSize(false);
        myreclerview.setLayoutManager(new LinearLayoutManager(this));
        databaseReference = FirebaseDatabase.getInstance().getReference().child("IndividualBudget");
        databaseReference.keepSynced(true);
        options = new FirebaseRecyclerOptions.Builder<IndividualBudgetModel>().setQuery(databaseReference, IndividualBudgetModel.class).build();
        individualBudgetModelList = new ArrayList<>();

        adapter = new FirebaseRecyclerAdapter<IndividualBudgetModel, RecyclerViewAdapterBhIndividual>(options) {
            @NonNull
            @Override
            public RecyclerViewAdapterBhIndividual onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(IndividualBudgetHistoryListView.this).inflate(R.layout.my_row_budgethistory_individual,parent,false);
                return new RecyclerViewAdapterBhIndividual(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull RecyclerViewAdapterBhIndividual recyclerViewAdapterBhIndividual, int i, @NonNull IndividualBudgetModel individualBudgetModel) {
                recyclerViewAdapterBhIndividual.tv_item.setText(individualBudgetModel.getIndividualBudgetName());
                recyclerViewAdapterBhIndividual.tv_Date.setText(individualBudgetModel.getIndividualBudgetBalance());
                recyclerViewAdapterBhIndividual.tv_price.setText(individualBudgetModel.getIndividualBudgetAmount());
            }


        };
        myreclerview.setAdapter(adapter);

    }
}