package com.example.budgetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

public class EventReunion extends AppCompatActivity {

    Button btnAdd,btnCancel;
    EditText txtAmount,txtCrowd;
    ArrayList<String> selection = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_reunion);


        btnAdd = findViewById(R.id.addReunion);
        btnCancel = findViewById(R.id.cancelreUNION);
        txtAmount = findViewById(R.id.ReunoinAmountBd);
        txtCrowd = findViewById(R.id.ReUnionCrowdBd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String amt =txtAmount.getText().toString().trim();
                final String crd =txtCrowd.getText().toString().trim();
                if (TextUtils.isEmpty(amt) ){
                    txtAmount.setError("Reunion amount is required.");
                }

                else if (TextUtils.isEmpty(crd)){
                    txtCrowd.setError("Birthday Crowd is required.");
                }
                else {
                    Intent intent = new Intent(EventReunion.this, EventReunionListView.class);
                    intent.putExtra("selectedReunionItems", selection);
                    intent.putExtra("ReunionAmount", txtAmount.getText().toString());
                    intent.putExtra("reunionCrowd", txtCrowd.getText().toString());
                    startActivity(intent);
                }
            }
        });
         btnCancel.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 finish();

             }
         });

    }
    public void selectReunionItem(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBoxRefreshmentBdR:
                if (checked) {
                    selection.add("Refreshment");
                } else {
                    selection.remove("Refreshment");
                }
                break;
            case R.id.checkBoxDecorationBdR:
                if (checked) {
                    selection.add("Decoration");
                } else {
                    selection.remove("Decoration");
                }
                break;
            case R.id.checkBoxBdCakeBdR:
                if (checked) {
                    selection.add("Cake");
                } else {
                    selection.remove("Cake");
                }
                break;
            case R.id.checkBoxMusicBdR:
                if (checked) {
                    selection.add("Music");
                } else {
                    selection.remove("Music");
                }
                break;
            case R.id.checkBoxDanGrpBdR:
                if (checked) {
                    selection.add("Dancing Group");
                } else {
                    selection.remove("Dancing Group");
                }
                break;
            case R.id.checkBoxphotoBdR:
                if (checked) {
                    selection.add("Photo / Video");
                } else {
                    selection.remove("Photo / Video");
                }
                break;
            case R.id.checkBoxEquipmentBdR:
                if (checked) {
                    selection.add("Equipment Hire");
                } else {
                    selection.remove("Equipment Hire");
                }
                break;
            case R.id.checkBoxTobaccoBdR:
                if (checked) {
                    selection.add("Tobacco / Alcohol");
                } else {
                    selection.remove("Tobacco / Alcohol");
                }
                break;
            case R.id.checkBoxInvitationBdR:
                if (checked) {
                    selection.add("Invitations");
                } else {
                    selection.remove("Invitations");
                }
                break;
            case R.id.checkBoxOtherBdR:
                if (checked) {
                    selection.add("Other");
                } else {
                    selection.remove("Other");
                }
                break;
        }
    }
}