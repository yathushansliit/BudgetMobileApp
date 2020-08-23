package com.example.budgetapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.budgetapplication.Models.IncomeModel;
import com.example.budgetapplication.Models.TotalExpensesModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class View_Income extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<IncomeModel> incomeArrayList,incomes;
    private FirebaseRecyclerOptions<IncomeModel> options;
    private FirebaseRecyclerAdapter<IncomeModel,ViewIncomeAdapter> adapter;
    private DatabaseReference databaseReference;
    EditText updateIncomeType,updateIncomeAmount,updateIncomeDate;
    Context context ;
    String key1;

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
        setContentView(R.layout.activity_view__income);

        recyclerView = findViewById(R.id.recyclerViewIncome);
        //incomes = new ArrayList<>();
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //incomeArrayList=new ArrayList<IncomeModel>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Income");
        databaseReference.keepSynced(true);
        options = new FirebaseRecyclerOptions.Builder<IncomeModel>().setQuery(databaseReference, IncomeModel.class).build();



        adapter = new FirebaseRecyclerAdapter<IncomeModel, ViewIncomeAdapter>(options) {
            @NonNull
            @Override
            public ViewIncomeAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(View_Income.this).inflate(R.layout.my_row_view_income,parent,false);
                return new ViewIncomeAdapter(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ViewIncomeAdapter viewIncomeAdapter, final int i, @NonNull IncomeModel incomeModel) {
                viewIncomeAdapter.txtType.setText(incomeModel.getIncomeType());
                viewIncomeAdapter.txtAmount.setText(incomeModel.getIncomeAmount());
                viewIncomeAdapter.txtDate.setText(incomeModel.getIncomeDate());
                viewIncomeAdapter.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        final String key = getRef(i).getKey();
                        databaseReference.child(key).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists() ){
                                    String incomeType= snapshot.child("incomeType").getValue().toString();
                                    String incomeAmount= snapshot.child("incomeAmount").getValue().toString();
                                    String incomeDate= snapshot.child("incomeDate").getValue().toString();

                                    showUpdateDialog(key,incomeType,incomeAmount,incomeDate);
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

     private void showUpdateDialog(final String incomeId, String incomeType, String incomeAmount, String incomeDate) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.activity_update_income, null);
        dialogBuilder.setView(dialogView);

        final EditText updateIncomeType = (EditText) dialogView.findViewById(R.id.updateIncomeType);
        final EditText updateIncomeAmount = (EditText) dialogView.findViewById(R.id.updateIncomeAmount);
        final EditText updateIncomeDate = (EditText) dialogView.findViewById(R.id.updateIncomeDate);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.UpdateIncome);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.DeleteIncome);
        final Button buttonCancel = (Button) dialogView.findViewById(R.id.CancelIncome);

        updateIncomeType.setText(incomeType);
        updateIncomeAmount.setText(incomeAmount);
        updateIncomeDate.setText(incomeDate);


        dialogBuilder.setTitle(incomeType);
        final AlertDialog b = dialogBuilder.create();
        b.show();


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String incomeType = updateIncomeType.getText().toString().trim();
                String amount = updateIncomeAmount.getText().toString().trim();
                String date = updateIncomeDate.getText().toString().trim();
                if (!TextUtils.isEmpty(incomeType)) {
                    updateIncome(incomeId, incomeType, amount,date);
                    b.dismiss();
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteIncome(incomeId);
            }
        });

         buttonCancel.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 b.dismiss();
             }
         });


    }


    private boolean updateIncome(String incomeId, String incomeType, String amount, String date) {
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("Income").child(incomeId);

        IncomeModel incomeModel = new IncomeModel(incomeId, incomeType, amount,date);
        dR.setValue(incomeModel);
        Toast.makeText(getApplicationContext(), "Income Updated", Toast.LENGTH_LONG).show();
        return true;
    }

    private void deleteIncome(String incomeId){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Income").child(incomeId);
        databaseReference.removeValue();
        Toast.makeText(getApplicationContext(), "Income Deleted", Toast.LENGTH_LONG).show();
    }
}