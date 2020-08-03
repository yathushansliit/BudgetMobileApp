package com.example.budgetapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.budgetapplication.ExpenseModels.IndividualExpense;
import com.example.budgetapplication.ExpenseModels.TotalExpenses;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AddtoBudgetFragment03 extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    EditText txtEventAmount;
    EditText txtEventDate;

    DatabaseReference databaseEventExpense;
    DatabaseReference databaseTotalExpense;

    public AddtoBudgetFragment03() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        databaseEventExpense = FirebaseDatabase.getInstance().getReference("Event");
        databaseTotalExpense = FirebaseDatabase.getInstance().getReference("Expenses");

        View view = inflater.inflate(R.layout.addtobudget_fragment03,container,false);

        spinner = view.findViewById(R.id.EventSpinner);
        txtEventAmount = view.findViewById(R.id.txtEventAmount);
        txtEventDate = view.findViewById(R.id.txtEventDate);

        spinner.setOnItemSelectedListener(this);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(),R.array.SpinnerEvent,R.layout.spinner_colour);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        Button button = (Button) view.findViewById(R.id.AddEventExpenseBtn);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    case R.id.AddEventExpenseBtn:
                        addEventExpense();
                        Intent intent1 = new Intent(getActivity(), viewExpense.class);
                        startActivity(intent1);//Edited here
                        break;


                }
            }
        });
        return view;
    }

    private void addEventExpense(){
        String expenseName = spinner.getSelectedItem().toString();
        String amount = txtEventAmount.getText().toString().trim();
        String date = txtEventDate.getText().toString().trim();

        if(!TextUtils.isEmpty(amount)){
            String id = databaseEventExpense.push().getKey();
            IndividualExpense individualExpense = new IndividualExpense(id,expenseName,amount,date,"Event");
            databaseEventExpense.child(id).setValue(individualExpense);

            TotalExpenses totalExpenses = new TotalExpenses(id,expenseName,amount,date,"Event");
            databaseTotalExpense.child(id).setValue(totalExpenses);

            Toast.makeText(getActivity(), "Event Expense is added",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getActivity(), "You should enter the amount", Toast.LENGTH_LONG).show();
        }



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
