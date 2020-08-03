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

import com.example.budgetapplication.ExpenseModels.FamilyExpense;
import com.example.budgetapplication.ExpenseModels.IndividualExpense;
import com.example.budgetapplication.ExpenseModels.TotalExpenses;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AddtoBudgetFragment02 extends Fragment implements AdapterView.OnItemSelectedListener{
    Spinner spinner;
    EditText txtFamilyAmount;
    EditText txtFamilyDate;

    DatabaseReference databaseFamilyExpense;
    DatabaseReference databaseTotalExpense;


    public AddtoBudgetFragment02() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        databaseFamilyExpense = FirebaseDatabase.getInstance().getReference("Family");
        databaseTotalExpense = FirebaseDatabase.getInstance().getReference("Expenses");

        View view = inflater.inflate(R.layout.addtobudget_fragment02,container,false);

        spinner = view.findViewById(R.id.FamilySpinner);
        txtFamilyAmount = view.findViewById(R.id.txtFamilyAmount);
        txtFamilyDate = view.findViewById(R.id.txtFamilyDate);

        spinner.setOnItemSelectedListener(this);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(),R.array.SpinnerIndividual,R.layout.spinner_colour);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        Button button = (Button) view.findViewById(R.id.AddFamilyExpenseBtn);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    case R.id.AddFamilyExpenseBtn:
                        addFamilyExpense();
                        Intent intent1 = new Intent(getActivity(), viewExpense.class);
                        startActivity(intent1);//Edited here
                        break;
                }
            }
        });
        return view;
    }

    private void addFamilyExpense(){
        String expenseName = spinner.getSelectedItem().toString();
        String amount = txtFamilyAmount.getText().toString().trim();
        String date = txtFamilyDate.getText().toString().trim();

        if(!TextUtils.isEmpty(amount)){
            String id = databaseFamilyExpense.push().getKey();
            FamilyExpense familyExpense = new FamilyExpense(id,expenseName,amount,date,"Family");
            databaseFamilyExpense.child(id).setValue(familyExpense);

            TotalExpenses totalExpenses = new TotalExpenses(id,expenseName,amount,date,"Family");
            databaseTotalExpense.child(id).setValue(totalExpenses);

            Toast.makeText(getActivity(), "Family Expense is added",Toast.LENGTH_LONG).show();
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
