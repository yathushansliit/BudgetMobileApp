package com.example.budgetapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.budgetapplication.Models.IncomeModel;
import com.example.budgetapplication.Models.IndividualExpenseModel;
import com.example.budgetapplication.Models.TotalExpensesModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class viewExpense extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<TotalExpensesModel> arrayList;
    private FirebaseRecyclerOptions<TotalExpensesModel> options;
    private FirebaseRecyclerAdapter<TotalExpensesModel,FirebaseViewHolder> adapter;
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
        arrayList=new ArrayList<TotalExpensesModel>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Expenses");
        databaseReference.keepSynced(true);
        options = new FirebaseRecyclerOptions.Builder<TotalExpensesModel>().setQuery(databaseReference, TotalExpensesModel.class).build();

          adapter = new FirebaseRecyclerAdapter<TotalExpensesModel, FirebaseViewHolder>(options) {

              @NonNull
              @Override
              public FirebaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                  return new FirebaseViewHolder(LayoutInflater.from(viewExpense.this).inflate(R.layout.my_row_view_expense,parent,false));

              }


              @Override
              protected void onBindViewHolder(@NonNull FirebaseViewHolder holder,final int i, @NonNull TotalExpensesModel totalExpensesModel) {
                  holder.expenseName.setText(totalExpensesModel.getExpenseName());
                  holder.expenseAmount.setText(totalExpensesModel.getExpenseAmount());
                  holder.expenseDate.setText(totalExpensesModel.getExpenseDate());
                  holder.expenseType.setText(totalExpensesModel.getExpenseType());
                  holder.itemView.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {
                          final String key = getRef(i).getKey();
                          databaseReference.child(key).addValueEventListener(new ValueEventListener() {
                              @Override
                              public void onDataChange(@NonNull DataSnapshot snapshot) {
                                  if(snapshot.exists() ){
                                      String expenseName= snapshot.child("expenseName").getValue().toString();
                                      String expenseAmount= snapshot.child("expenseAmount").getValue().toString();
                                      String expenseDate= snapshot.child("expenseDate").getValue().toString();
                                     // String expenseType =snapshot.child("expenseType").getValue().toString();

                                      showUpdateDialog(key,expenseName,expenseAmount,expenseDate);
                                  }
                              }
                              @Override
                              public void onCancelled(@NonNull DatabaseError error) {

                              }
                          });

                      }
                  });
              }
          };
           recyclerView.setAdapter(adapter);
    }

    private void showUpdateDialog(final String expenseId, String expenseName, String expenseAmount, String expenseDate) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_delete_expense, null);
        dialogBuilder.setView(dialogView);

        final Spinner updateExpenseSpinner = (Spinner) dialogView.findViewById(R.id.updateExpenseSpinner);
        final EditText updateExpenseAmount = (EditText) dialogView.findViewById(R.id.updateExpenseAmount);
        final EditText updateExpenseDate = (EditText) dialogView.findViewById(R.id.updateExpenseDate);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.UpdateExpenseBtn);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.DeleteExpenseBtn);
        final Button buttonCancel = (Button) dialogView.findViewById(R.id.CancelExpenseBtn);

       //updateExpenseSpinner.setSelection(Integer.parseInt(expenseName));
        updateExpenseAmount.setText(expenseAmount);
        updateExpenseDate.setText(expenseDate);

        dialogBuilder.setTitle(expenseName);
        final AlertDialog b = dialogBuilder.create();
        b.show();

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String expenseName = updateExpenseSpinner.getSelectedItem().toString().trim();
                String expenseAmount = updateExpenseAmount.getText().toString().trim();
                String expenseDate = updateExpenseDate.getText().toString().trim();
                if (!TextUtils.isEmpty(expenseName)) {
                    updateExpense(expenseId, expenseName, expenseAmount,expenseDate);
                    b.dismiss();
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteExpense(expenseId);
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b.dismiss();
            }
        });


    }


    private boolean updateExpense(String expenseId, String expenseName, String expenseAmount, String expenseDate) {
        DatabaseReference expenseDataReference = FirebaseDatabase.getInstance().getReference("Expenses").child(expenseId);

        TotalExpensesModel totalExpensesModel = new TotalExpensesModel(expenseId, expenseName, expenseAmount,expenseDate);
        expenseDataReference.setValue(totalExpensesModel);
        Toast.makeText(getApplicationContext(), "Expense Updated", Toast.LENGTH_LONG).show();
        return true;
    }

    private void deleteExpense(String expenseId){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Expenses").child(expenseId);
        databaseReference.removeValue();
        Toast.makeText(getApplicationContext(), "Income Deleted", Toast.LENGTH_LONG).show();
    }
}