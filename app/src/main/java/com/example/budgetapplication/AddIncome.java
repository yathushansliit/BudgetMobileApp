package com.example.budgetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.budgetapplication.Models.IncomeModel;
import com.example.budgetapplication.Models.TotalExpensesModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddIncome extends AppCompatActivity {

    Button button;
    EditText txtIncomeType;
    EditText txtIncomeAmount;
    EditText txtIncomeDate;

    DatabaseReference databaseIncome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);

        databaseIncome = FirebaseDatabase.getInstance().getReference("Income");

        button = findViewById(R.id.AddIncomeBtn);
        txtIncomeType = findViewById(R.id.incomeType);
        txtIncomeAmount = findViewById(R.id.incomeAmount);
        txtIncomeDate = findViewById(R.id.incomeDate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addIncome();
                Intent intent = new Intent(AddIncome.this, View_Income.class);
                startActivity(intent);
            }
        });

    }


    private void addIncome(){

        String type = txtIncomeType.getText().toString().trim();
        String amount = txtIncomeType.getText().toString().trim();
        String date = txtIncomeDate.getText().toString().trim();

        if(!TextUtils.isEmpty(amount)){
            String id = databaseIncome.push().getKey();
            IncomeModel incomeModel = new IncomeModel(id,type,amount,date);
            databaseIncome.child(id).setValue(incomeModel);

            Toast.makeText(this, "Income is added",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "You should enter the amount", Toast.LENGTH_LONG).show();
        }



    }
}