package com.example.budgetapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.budgetapplication.Models.IndividualExpenseModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class IndividualListView extends AppCompatActivity {
    private RecyclerView recyclerView;
    private IndividualAdapter individualAdapter;
    private List<IndividualExpenseModel> individualExpenseModelList;
    private ArrayList<String> selectedItemsList;
    Integer amount =0;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_list_view);

        Bundle bundle = getIntent().getExtras();
        selectedItemsList=bundle.getStringArrayList("selectedItems");

        Toast.makeText(this, selectedItemsList.toString() ,Toast.LENGTH_LONG).show();

        recyclerView = findViewById(R.id.recyclerIndividual);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        individualExpenseModelList = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("individual");
      //  databaseReference.addListenerForSingleValueEvent(valueEventListener);

        if(selectedItemsList.contains("Food"))
        {
            Query query1 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Food");
            query1.addListenerForSingleValueEvent(valueEventListener);
        }
       if(selectedItemsList.contains("Insurance")) {
            Query query2 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Insurance");
            query2.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedItemsList.contains("Home Repair")) {
            Query query3 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Home Repair");
            query3.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedItemsList.contains("Transport")) {
            Query query4 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Transport");
            query4.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedItemsList.contains("Vehicle Maintenance")) {
            Query query5 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Vehicle Maintenance");
            query5.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedItemsList.contains("Education")) {
            Query query6 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Education");
            query6.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedItemsList.contains("Entertainment")) {
            Query query7 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Entertainment");
            query7.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedItemsList.contains("Clothing")) {
            Query query8 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Clothing");
            query8.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedItemsList.contains("Alchohol / Tobacco")) {
            Query query9 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Alchohol / Tobacco");
            query9.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedItemsList.contains("Health Care")) {
            Query query10 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Health Care");
            query10.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedItemsList.contains("Sports")) {
            Query query11 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Sports");
            query11.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedItemsList.contains("Glossaries")) {
            Query query12 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Glossaries");
            query12.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedItemsList.contains("Saloon Service")) {
            Query query13 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Saloon Service");
            query13.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedItemsList.contains("Utility Bills")) {
            Query query14 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Utility Bills");
            query14.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedItemsList.contains("Magazines")) {
            Query query15 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Magazines");
            query15.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedItemsList.contains("Rent")) {
            Query query16 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Rent");
            query16.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedItemsList.contains("Occasions")) {
            Query query17 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Occasions");
            query17.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedItemsList.contains("Property Tax")) {
            Query query18 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Property Tax");
            query18.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedItemsList.contains("Donations")) {
            Query query19 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Donations");
            query19.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedItemsList.contains("Vacation")) {
            Query query20 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Vacation");
            query20.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedItemsList.contains("Vehicle Insurance")) {
            Query query21 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Vehicle Insurance");
            query21.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedItemsList.contains("Loan Payment")) {
            Query query22 = FirebaseDatabase.getInstance().getReference("individual")
                    .orderByChild("individualExpenseName")
                    .equalTo("Loan Payment");
            query22.addListenerForSingleValueEvent(valueEventListener);
        }

        individualAdapter = new IndividualAdapter(this, individualExpenseModelList);
        recyclerView.setAdapter(individualAdapter);

    }


    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            //individualExpenseList.clear();
            if (dataSnapshot.exists()  ) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    IndividualExpenseModel individualExpenseModel = snapshot.getValue(IndividualExpenseModel.class);

                    individualExpenseModelList.add(individualExpenseModel);
                    amount = amount + Integer.parseInt(individualExpenseModel.getIndividualExpenseAmount());
                }
                individualAdapter.notifyDataSetChanged();
                Log.d("List", String.valueOf(individualExpenseModelList));
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };




}