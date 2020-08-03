package com.example.budgetapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.budgetapplication.ExpenseModels.FamilyExpense;
import com.example.budgetapplication.ExpenseModels.IndividualExpense;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class familyListView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FamilyAdapter familyAdapter;
    private List<FamilyExpense> familyExpenseList;
    private ArrayList<String> selectedFamilyItemsList;
    Integer amount =0;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_list_view);

        Bundle bundle = getIntent().getExtras();
        selectedFamilyItemsList=bundle.getStringArrayList("selectedFamilyItems");

        Toast.makeText(this, selectedFamilyItemsList.toString() ,Toast.LENGTH_LONG).show();

        recyclerView = findViewById(R.id.recyclerFamily);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        familyExpenseList = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("Family");

        if(selectedFamilyItemsList.contains("Food"))
        {
            Query query1 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Food");
            query1.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedFamilyItemsList.contains("Insurance")) {
            Query query2 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Insurance");
            query2.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedFamilyItemsList.contains("Home Repair")) {
            Query query3 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Home Repair");
            query3.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedFamilyItemsList.contains("Transport")) {
            Query query4 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Transport");
            query4.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedFamilyItemsList.contains("Vehicle Maintenance")) {
            Query query5 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Vehicle Maintenance");
            query5.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedFamilyItemsList.contains("Education")) {
            Query query6 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Education");
            query6.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedFamilyItemsList.contains("Entertainment")) {
            Query query7 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Entertainment");
            query7.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedFamilyItemsList.contains("Clothing")) {
            Query query8 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Clothing");
            query8.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedFamilyItemsList.contains("Alchohol / Tobacco")) {
            Query query9 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Alchohol / Tobacco");
            query9.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedFamilyItemsList.contains("Health Care")) {
            Query query10 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Health Care");
            query10.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedFamilyItemsList.contains("Sports")) {
            Query query11 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Sports");
            query11.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedFamilyItemsList.contains("Glossaries")) {
            Query query12 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Glossaries");
            query12.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedFamilyItemsList.contains("Saloon Service")) {
            Query query13 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Saloon Service");
            query13.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedFamilyItemsList.contains("Utility Bills")) {
            Query query14 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Utility Bills");
            query14.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedFamilyItemsList.contains("Magazines")) {
            Query query15 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Magazines");
            query15.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedFamilyItemsList.contains("Rent")) {
            Query query16 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Rent");
            query16.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedFamilyItemsList.contains("Occasions")) {
            Query query17 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Occasions");
            query17.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedFamilyItemsList.contains("Property Tax")) {
            Query query18 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Property Tax");
            query18.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedFamilyItemsList.contains("Donations")) {
            Query query19 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Donations");
            query19.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedFamilyItemsList.contains("Vacation")) {
            Query query20 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Vacation");
            query20.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedFamilyItemsList.contains("Vehicle Insurance")) {
            Query query21 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Vehicle Insurance");
            query21.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedFamilyItemsList.contains("Loan Payment")) {
            Query query22 = FirebaseDatabase.getInstance().getReference("Family")
                    .orderByChild("familyExpenseName")
                    .equalTo("Loan Payment");
            query22.addListenerForSingleValueEvent(valueEventListener);
        }


        familyAdapter = new FamilyAdapter(this, familyExpenseList);
        recyclerView.setAdapter(familyAdapter);

    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            //familyExpenseList.clear();
            if (dataSnapshot.exists()  ) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    FamilyExpense familyExpense = snapshot.getValue(FamilyExpense.class);

                    familyExpenseList.add(familyExpense);
                   amount = amount + Integer.parseInt(familyExpense.getFamilyExpenseAmount());

                }
                familyAdapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };
}