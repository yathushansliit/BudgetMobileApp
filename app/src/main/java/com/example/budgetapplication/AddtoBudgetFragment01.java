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

import com.example.budgetapplication.Models.IndividualExpenseModel;
import com.example.budgetapplication.Models.TotalExpensesModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AddtoBudgetFragment01 extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    EditText txtIndiviualAmount;
    EditText txtIndiviualDate;

    DatabaseReference databaseIndiviualExpense;
    DatabaseReference databaseTotalExpense;

    public AddtoBudgetFragment01() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        databaseIndiviualExpense = FirebaseDatabase.getInstance().getReference("individual");
        databaseTotalExpense = FirebaseDatabase.getInstance().getReference("Expenses");


        View view = inflater.inflate(R.layout.addtobudget_fragment01,container,false);

        spinner = view.findViewById(R.id.individualSpinner);
        txtIndiviualAmount = view.findViewById(R.id.txtIndiviualAmount);
        txtIndiviualDate = view.findViewById(R.id.txtIndiviualDate);

        spinner.setOnItemSelectedListener(this);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(),R.array.SpinnerIndividual,R.layout.spinner_colour);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Button button = (Button) view.findViewById(R.id.AddExpenseBtn);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    case R.id.AddExpenseBtn:
                        addIndividualExpense();
                        Intent intent1 = new Intent(getActivity(), viewExpense.class);
                        startActivity(intent1);//Edited here
                        break;


                }
            }
        });
        return view;
    }

    private void addIndividualExpense(){
        String expenseName = spinner.getSelectedItem().toString();
        String amount = txtIndiviualAmount.getText().toString().trim();
        String date = txtIndiviualAmount.getText().toString().trim();

        if(!TextUtils.isEmpty(amount)){
            String id = databaseIndiviualExpense.push().getKey();

            IndividualExpenseModel individualExpenseModel = new IndividualExpenseModel(id,expenseName,amount,date,"Individual");
            databaseIndiviualExpense.child(id).setValue(individualExpenseModel);

            TotalExpensesModel totalExpensesModel = new TotalExpensesModel(id,expenseName,amount,date,"Individual");
            databaseTotalExpense.child(id).setValue(totalExpensesModel);

            Toast.makeText(getActivity(), "Individual Expense is added",Toast.LENGTH_LONG).show();
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
