package com.example.budgetapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

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

        databaseIndiviualExpense = FirebaseDatabase.getInstance().getReference().child("individual");
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
                        final String expenseName = spinner.getSelectedItem().toString();
                        final String amount = txtIndiviualAmount.getText().toString().trim();
                        final String date = txtIndiviualDate.getText().toString().trim();
                        if(TextUtils.isEmpty(amount)  && TextUtils.isEmpty(date)){
                            txtIndiviualAmount.setError("Amount is required.");
                           txtIndiviualDate.setError("Date is required.");
                        }
                        else {
                            addIndividualExpense();
                            Intent intent1 = new Intent(getActivity(), viewExpense.class);
                            startActivity(intent1);//Edited here
                        }


                        break;


                }
            }
        });
        return view;
    }

    private void addIndividualExpense(){
        final String expenseName = spinner.getSelectedItem().toString();
        final String amount = txtIndiviualAmount.getText().toString().trim();
        final String date = txtIndiviualDate.getText().toString().trim();

        //This method is checking the specific expence in the database, if its already exists the if condition modify the specific expence
        if(!TextUtils.isEmpty(amount)) {
            databaseIndiviualExpense.orderByChild("individualExpenseName").equalTo(expenseName).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()) {
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            String id = dataSnapshot1.child("individualExpenseId").getValue().toString();

                            DatabaseReference updateDataReference = FirebaseDatabase.getInstance().getReference("individual").child(id);
                            IndividualExpenseModel individualExpenseModel = new IndividualExpenseModel(id,expenseName,amount,date,"Individual");
                            updateDataReference.setValue(individualExpenseModel);

                            DatabaseReference updateTotExpDataRef = FirebaseDatabase.getInstance().getReference("Expenses").child(id);
                            TotalExpensesModel totalExpensesModel = new TotalExpensesModel(id,expenseName,amount,date,"Individual");
                            updateTotExpDataRef.setValue(totalExpensesModel);

                            Toast.makeText(getActivity(), "modified",Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        String id = databaseIndiviualExpense.push().getKey();

                        IndividualExpenseModel individualExpenseModel = new IndividualExpenseModel(id,expenseName,amount,date,"Individual");
                        databaseIndiviualExpense.child(id).setValue(individualExpenseModel);


                        TotalExpensesModel totalExpensesModel = new TotalExpensesModel(id,expenseName,amount,date,"Individual");
                        databaseTotalExpense.child(id).setValue(totalExpensesModel);

                        Toast.makeText(getActivity(), "Individual Expense is added",Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }
    }


//    ValueEventListener valueEventListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                //individualExpenseList.clear();
//                if (dataSnapshot.exists()  ) {
//
//
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        };

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
