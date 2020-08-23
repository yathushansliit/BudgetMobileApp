package com.example.budgetapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.budgetapplication.Models.EventBudgetModel;
import com.example.budgetapplication.Models.EventModel;
import com.example.budgetapplication.Models.FamilyBudgetModel;
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

public class BugetHistoryfragment03 extends Fragment {

    View v;
    private RecyclerView myreclerview;
    private List<EventBudgetModel> eventBudgetModelList;
    private FirebaseRecyclerAdapter<EventBudgetModel,RecyclerViewAdapterBhEvent> adapter;
    private DatabaseReference databaseReference;
    private FirebaseRecyclerOptions<EventBudgetModel> options;

    public BugetHistoryfragment03() {
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

        v = inflater.inflate(R.layout.budgethistory_fragment03, container,false);

        myreclerview = (RecyclerView) v.findViewById(R.id.recyclerBhEvent);
        myreclerview.setHasFixedSize(false);
        myreclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        databaseReference = FirebaseDatabase.getInstance().getReference().child("EventBudget");
        databaseReference.keepSynced(true);
        options = new FirebaseRecyclerOptions.Builder<EventBudgetModel>().setQuery(databaseReference, EventBudgetModel.class).build();
        eventBudgetModelList = new ArrayList<>();
        adapter = new FirebaseRecyclerAdapter<EventBudgetModel, RecyclerViewAdapterBhEvent>(options) {

            @NonNull
            @Override
            public RecyclerViewAdapterBhEvent onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = inflater.from(getContext()).inflate(R.layout.my_row_budgethistory_event,parent,false);
                return new RecyclerViewAdapterBhEvent(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull RecyclerViewAdapterBhEvent recyclerViewAdapterBhEvent, int i, @NonNull EventBudgetModel eventBudgetModel) {
                recyclerViewAdapterBhEvent.tv_item.setText(eventBudgetModel.getEventBudgetName());
                recyclerViewAdapterBhEvent.tv_Date.setText(eventBudgetModel.getEventType());
                recyclerViewAdapterBhEvent.tv_price.setText(eventBudgetModel.getEventTotalBudgetAmount());
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
