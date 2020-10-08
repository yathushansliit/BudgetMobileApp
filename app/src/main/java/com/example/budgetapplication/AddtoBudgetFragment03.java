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

import com.example.budgetapplication.Models.EventModel;
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
                        final String expenseName = spinner.getSelectedItem().toString();
                        final String amount = txtEventAmount.getText().toString().trim();
                        final String date = txtEventDate.getText().toString().trim();
                        if(TextUtils.isEmpty(amount)  && TextUtils.isEmpty(date)){
                            txtEventAmount.setError("Amount is required.");
                            txtEventDate.setError("Date is required.");
                        }
                        else {
                            addEventExpense();
                            Intent intent1 = new Intent(getActivity(), viewExpense.class);
                            startActivity(intent1);//Edited here
                        }
                        break;


                }
            }
        });
        return view;
    }

    private void addEventExpense(){
        final String expenseName = spinner.getSelectedItem().toString();
        final String amount = txtEventAmount.getText().toString().trim();
        final String date = txtEventDate.getText().toString().trim();

        //This method is checking the specific expence in the database, if its already exists the if condition modify the specific expence
        if(!TextUtils.isEmpty(amount)) {
            databaseEventExpense.orderByChild("eventExpenseName").equalTo(expenseName).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            String id = dataSnapshot1.child("eventExpenseId").getValue().toString();

                            DatabaseReference updateDataReference = FirebaseDatabase.getInstance().getReference("Event").child(id);
                            EventModel eventModel = new EventModel(id, expenseName, amount, date, "Event");
                            updateDataReference.setValue(eventModel);

                            DatabaseReference updateTootExpDataRef = FirebaseDatabase.getInstance().getReference("Expenses").child(id);
                            TotalExpensesModel totalExpensesModel = new TotalExpensesModel(id, expenseName, amount, date, "Event");
                            updateTootExpDataRef.setValue(totalExpensesModel);

                            Toast.makeText(getActivity(), "modified", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        String id = databaseEventExpense.push().getKey();

                        EventModel eventModel = new EventModel(id, expenseName, amount, date, "Event");
                        databaseEventExpense.child(id).setValue(eventModel);


                        TotalExpensesModel totalExpensesModel = new TotalExpensesModel(id, expenseName, amount, date, "Event");
                        databaseTotalExpense.child(id).setValue(totalExpensesModel);

                        Toast.makeText(getActivity(), "Event Expense is added", Toast.LENGTH_LONG).show();
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
