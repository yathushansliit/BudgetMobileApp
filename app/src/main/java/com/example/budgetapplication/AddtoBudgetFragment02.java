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

import com.example.budgetapplication.Models.FamilyExpenseModel;
import com.example.budgetapplication.Models.IndividualExpenseModel;
import com.example.budgetapplication.Models.TotalExpensesModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
                        final String famexpenseName = spinner.getSelectedItem().toString();
                        final String amount = txtFamilyAmount.getText().toString().trim();
                        final String date = txtFamilyDate.getText().toString().trim();
                        if(TextUtils.isEmpty(amount)  && TextUtils.isEmpty(date)){
                            txtFamilyAmount.setError("Amount is required.");
                            txtFamilyDate.setError("Date is required.");
                        }
                        else {
                            addFamilyExpense();
                            Intent intent1 = new Intent(getActivity(), viewExpense.class);
                            startActivity(intent1);//Edited here
                        }
                        break;
                }
            }
        });
        return view;
    }

    private void addFamilyExpense(){
        final String famexpenseName = spinner.getSelectedItem().toString();
        final String amount = txtFamilyAmount.getText().toString().trim();
        final String date = txtFamilyDate.getText().toString().trim();

        //This method is checking the specific expence in the database, if its already exists the if condition modify the specific expence
        if(!TextUtils.isEmpty(amount)) {
            databaseFamilyExpense.orderByChild("familyExpenseName").equalTo(famexpenseName).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            String id = dataSnapshot1.child("familyExpenseId").getValue().toString();

                            DatabaseReference updatefamDataReference = FirebaseDatabase.getInstance().getReference("Family").child(id);
                            FamilyExpenseModel familyExpenseModel = new FamilyExpenseModel(id, famexpenseName, amount, date, "Family");
                            updatefamDataReference.setValue(familyExpenseModel);

                            DatabaseReference updateTottExpDataRef = FirebaseDatabase.getInstance().getReference("Expenses").child(id);
                            TotalExpensesModel totalExpensesModel = new TotalExpensesModel(id, famexpenseName, amount, date, "Family");
                            updateTottExpDataRef.setValue(totalExpensesModel);

                            Toast.makeText(getActivity(), "modified", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        String id = databaseFamilyExpense.push().getKey();

                        FamilyExpenseModel familyExpenseModel = new FamilyExpenseModel(id, famexpenseName, amount, date, "Family");
                        databaseFamilyExpense.child(id).setValue(familyExpenseModel);


                        TotalExpensesModel totalExpensesModel = new TotalExpensesModel(id, famexpenseName, amount, date, "Family");
                        databaseTotalExpense.child(id).setValue(totalExpensesModel);

                        Toast.makeText(getActivity(), "Family Expense is added", Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
