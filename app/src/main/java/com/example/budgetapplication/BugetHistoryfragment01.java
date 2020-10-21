package com.example.budgetapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.budgetapplication.Models.IndividualBudgetModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BugetHistoryfragment01 extends Fragment {

    View v;
    private RecyclerView myreclerview;
    private List<IndividualBudgetModel> individualBudgetModelList;
    private FirebaseRecyclerAdapter<IndividualBudgetModel,RecyclerViewAdapterBhIndividual> adapter;
    private DatabaseReference databaseReference;
    private FirebaseRecyclerOptions<IndividualBudgetModel> options;

    public BugetHistoryfragment01() {
    }

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
    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

      v = inflater.inflate(R.layout.budgethistory_fragment01, container,false);
        myreclerview = (RecyclerView) v.findViewById(R.id.recyclerBhIndividual);
        myreclerview.setHasFixedSize(false);
        myreclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        databaseReference = FirebaseDatabase.getInstance().getReference().child("IndividualBudget");
        databaseReference.keepSynced(true);
        options = new FirebaseRecyclerOptions.Builder<IndividualBudgetModel>().setQuery(databaseReference, IndividualBudgetModel.class).build();
        individualBudgetModelList = new ArrayList<>();
        adapter = new FirebaseRecyclerAdapter<IndividualBudgetModel, RecyclerViewAdapterBhIndividual>(options) {
            @NonNull
            @Override
            public RecyclerViewAdapterBhIndividual onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = inflater.from(getContext()).inflate(R.layout.my_row_budgethistory_individual,parent,false);
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
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        individualBudgetModelList = new ArrayList<>();

    }
}
