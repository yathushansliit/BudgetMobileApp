package com.example.budgetapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateIncome extends AppCompatActivity {

    EditText updateIncomeType,updateIncomeAmount,updateIncomeDate;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_income);

//        updateIncomeType = (EditText) findViewById(R.id.updateIncomeType);
//        updateIncomeAmount = (EditText) findViewById(R.id.updateIncomeAmount);
//        updateIncomeDate = (EditText) findViewById(R.id.updateIncomeDate);
//
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("Income");
//        String key = getIntent().getStringExtra("id");
//
//        databaseReference.child(key).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.exists()){
//                    String incomeType= snapshot.child("incomeType").getValue().toString();
//                    String incomeAmount= snapshot.child("incomeAmount").getValue().toString();
//                    String incomeDate= snapshot.child("incomeDate").getValue().toString();
//
//                    updateIncomeType.setText(incomeType);
//                    updateIncomeAmount.setText(incomeAmount);
//                    updateIncomeDate.setText(incomeDate);
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//
//        updateIncomeType.setText("id :" +key);





    }
}