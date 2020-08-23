package com.example.budgetapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.budgetapplication.Models.FamilyBudgetModel;
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

public class BugetHistoryfragment02 extends Fragment {

    View v;
    private RecyclerView myreclerview;
    private List<FamilyBudgetModel> familyBudgetModelList;
    private FirebaseRecyclerAdapter<FamilyBudgetModel,RecyclerViewAdapterBhFamily> adapter;
    private DatabaseReference databaseReference;
    private FirebaseRecyclerOptions<FamilyBudgetModel> options;

    public BugetHistoryfragment02() {
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

        v = inflater.inflate(R.layout.budgethistory_fragment02, container,false);
        myreclerview = (RecyclerView) v.findViewById(R.id.recyclerBhFamily);
        myreclerview.setHasFixedSize(false);
        myreclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        databaseReference = FirebaseDatabase.getInstance().getReference().child("FamilyBudget");
        databaseReference.keepSynced(true);
        options = new FirebaseRecyclerOptions.Builder<FamilyBudgetModel>().setQuery(databaseReference, FamilyBudgetModel.class).build();
        familyBudgetModelList = new ArrayList<>();
        adapter = new FirebaseRecyclerAdapter<FamilyBudgetModel, RecyclerViewAdapterBhFamily>(options) {
            @NonNull
            @Override
            public RecyclerViewAdapterBhFamily onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = inflater.from(getContext()).inflate(R.layout.my_row_budgethistory_family,parent,false);
                return new RecyclerViewAdapterBhFamily(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull RecyclerViewAdapterBhFamily recyclerViewAdapterBhFamily, int i, @NonNull FamilyBudgetModel familyBudgetModel) {
                recyclerViewAdapterBhFamily.tv_item.setText(familyBudgetModel.getFamilyBudgetName());
                recyclerViewAdapterBhFamily.tv_Date.setText(familyBudgetModel.getFamilyBudgetAmount());
                recyclerViewAdapterBhFamily.tv_price.setText(familyBudgetModel.getFamilyTotalBudgetAmount());
            }
        };

        myreclerview.setAdapter(adapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

}
