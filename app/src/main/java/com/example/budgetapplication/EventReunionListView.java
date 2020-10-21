package com.example.budgetapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.budgetapplication.Models.EventBudgetModel;
import com.example.budgetapplication.Models.EventModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EventReunionListView extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private List<EventModel> eventModelList;
    private ArrayList<String> selectedEventItemsList;

    String eventType;
    Integer budgetAmount,crowd;
    EditText txtEventBudgetName;
    Button btnSave,btnClose;
    Integer totalBudgetAmount=0;
    DatabaseReference databaseReference;
    DatabaseReference eventBudgetDatabaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_reunion_list_view);

        eventBudgetDatabaseReference = FirebaseDatabase.getInstance().getReference("EventBudget");

        btnSave = findViewById(R.id.rsaveEvent);
        btnClose = findViewById(R.id.rcancel);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSaveBudgetDialog();
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        Bundle bundle = getIntent().getExtras();
        selectedEventItemsList=bundle.getStringArrayList("selectedReunionItems");
        budgetAmount = Integer.parseInt(bundle.getString("ReunionAmount"));
        crowd = Integer.parseInt(bundle.getString("reunionCrowd"));

        recyclerView = findViewById(R.id.recyclerEvent);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        eventModelList = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("Event");

        if(selectedEventItemsList.contains("Refreshment"))
        {
            Query query1 = FirebaseDatabase.getInstance().getReference("Event")
                    .orderByChild("eventExpenseName")
                    .equalTo("Refreshment");
            query1.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedEventItemsList.contains("Decoration"))
        {
            Query query1 = FirebaseDatabase.getInstance().getReference("Event")
                    .orderByChild("eventExpenseName")
                    .equalTo("Decoration");
            query1.addListenerForSingleValueEvent(valueEventListener);
        } if(selectedEventItemsList.contains("Cake"))
        {
            Query query1 = FirebaseDatabase.getInstance().getReference("Event")
                    .orderByChild("eventExpenseName")
                    .equalTo("Cake");
            query1.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedEventItemsList.contains("Music"))
        {
            Query query1 = FirebaseDatabase.getInstance().getReference("Event")
                    .orderByChild("eventExpenseName")
                    .equalTo("Music");
            query1.addListenerForSingleValueEvent(valueEventListener);
        } if(selectedEventItemsList.contains("Dancing Group"))
        {
            Query query1 = FirebaseDatabase.getInstance().getReference("Event")
                    .orderByChild("eventExpenseName")
                    .equalTo("Dancing Group");
            query1.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedEventItemsList.contains("Photo / Video"))
        {
            Query query1 = FirebaseDatabase.getInstance().getReference("Event")
                    .orderByChild("eventExpenseName")
                    .equalTo("Photo / Video");
            query1.addListenerForSingleValueEvent(valueEventListener);
        } if(selectedEventItemsList.contains("Equipment Hire"))
        {
            Query query1 = FirebaseDatabase.getInstance().getReference("Event")
                    .orderByChild("eventExpenseName")
                    .equalTo("Equipment Hire");
            query1.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedEventItemsList.contains("Tobacco / Alcohol"))
        {
            Query query1 = FirebaseDatabase.getInstance().getReference("Event")
                    .orderByChild("eventExpenseName")
                    .equalTo("Tobacco / Alcohol");
            query1.addListenerForSingleValueEvent(valueEventListener);
        } if(selectedEventItemsList.contains("Invitations"))
        {
            Query query1 = FirebaseDatabase.getInstance().getReference("Event")
                    .orderByChild("eventExpenseName")
                    .equalTo("Invitations");
            query1.addListenerForSingleValueEvent(valueEventListener);
        }
        if(selectedEventItemsList.contains("Other"))
        {
            Query query1 = FirebaseDatabase.getInstance().getReference("Event")
                    .orderByChild("eventExpenseName")
                    .equalTo("Other");
            query1.addListenerForSingleValueEvent(valueEventListener);
        }

        eventAdapter = new EventAdapter(this, eventModelList);
        recyclerView.setAdapter(eventAdapter);

    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            //individualExpenseList.clear();
            if (dataSnapshot.exists()  ) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    EventModel eventModel = snapshot.getValue(EventModel.class);

                    eventModelList.add(eventModel);
                    totalBudgetAmount = totalBudgetAmount + Integer.parseInt(eventModel.getEventExpenseAmount());
                    Log.d("Listlllllll", eventModel.getEventExpenseAmount());

                }
                eventAdapter.notifyDataSetChanged();
                Log.d("Listlllllll Amout", String.valueOf(totalBudgetAmount));
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

    private void showSaveBudgetDialog() {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.save_event_budget_dialog, null);
        dialogBuilder.setView(dialogView);

        txtEventBudgetName = (EditText) dialogView.findViewById(R.id.txtEventBudgetName);
        final Button btnSaveEventBudget = (Button) dialogView.findViewById(R.id.btnSaveEventBudget);
        final Button btnEventClose = (Button) dialogView.findViewById(R.id.btnEventClose);

        dialogBuilder.setTitle("Save Budget");
        final AlertDialog b = dialogBuilder.create();
        b.show();


        btnSaveEventBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveEventBudget();


            }
        });

        btnEventClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b.dismiss();
            }
        });

    }

    private void saveEventBudget(){
        String eventName = txtEventBudgetName.getText().toString().trim();

        if(TextUtils.isEmpty(eventName)){
            txtEventBudgetName.setError("Budget Name required.");
        }
        else{
            String id = eventBudgetDatabaseReference.push().getKey();

            EventBudgetModel eventBudgetModel = new EventBudgetModel(id,eventName,crowd.toString(),budgetAmount.toString(),totalBudgetAmount.toString(),eventModelList,"Reunion");
            eventBudgetDatabaseReference.child(id).setValue(eventBudgetModel);

            Toast.makeText(this, "Event Budget is added",Toast.LENGTH_LONG).show();
            finish();
        }
    }
 }