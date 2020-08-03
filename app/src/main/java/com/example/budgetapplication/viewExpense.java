package com.example.budgetapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.budgetapplication.ExpenseModels.TotalExpenses;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class viewExpense extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<TotalExpenses> arrayList;
    private FirebaseRecyclerOptions<TotalExpenses> options;
    private FirebaseRecyclerAdapter<TotalExpenses,FirebaseViewHolder> adapter;
    private DatabaseReference databaseReference;

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_expense);

        recyclerView = findViewById(R.id.recyclerViewExpense);

        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList=new ArrayList<TotalExpenses>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Expenses");
        databaseReference.keepSynced(true);
        options = new FirebaseRecyclerOptions.Builder<TotalExpenses>().setQuery(databaseReference,TotalExpenses.class).build();

          adapter = new FirebaseRecyclerAdapter<TotalExpenses, FirebaseViewHolder>(options) {
              @Override
              protected void onBindViewHolder(@NonNull FirebaseViewHolder holder, int i, @NonNull TotalExpenses totalExpenses) {
                  holder.expenseName.setText(totalExpenses.getExpenseName());
                  holder.expenseAmount.setText(totalExpenses.getExpenseAmount());
                  holder.expenseDate.setText(totalExpenses.getExpenseDate());
                  holder.expenseType.setText(totalExpenses.getExpenseType());
              }

              @NonNull
              @Override
              public FirebaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                  return new FirebaseViewHolder(LayoutInflater.from(viewExpense.this).inflate(R.layout.my_row_view_expense,parent,false));

              }
          };

           recyclerView.setAdapter(adapter);
    }
}