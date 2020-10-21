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

public class EventFarewell extends AppCompatActivity {
    EditText txtAmount,txtCrowd;
    Button btn,btn2;
    ArrayList<String> selection = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_farewell);


        btn = findViewById(R.id.addFarewell);
        txtAmount = findViewById(R.id.FarewellAmountBd);
        txtCrowd = findViewById(R.id.FarewellCrowdBd);
        btn2 = findViewById(R.id.farewellcancel);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String amt =txtAmount.getText().toString().trim();
                final String crd =txtCrowd.getText().toString().trim();
                if (TextUtils.isEmpty(amt) ){
                    txtAmount.setError("Farewell amount is required.");
                }

                else if (TextUtils.isEmpty(crd)){
                    txtCrowd.setError("Birthday Crowd is required.");
                }
                else {
                    Intent intent = new Intent(EventFarewell.this, EventFarewellListView.class);
                    intent.putExtra("selectedFairwellItems", selection);
                    intent.putExtra("FarewellAmount", txtAmount.getText().toString());
                    intent.putExtra("farecrowd", txtCrowd.getText().toString());

                    startActivity(intent);
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
    }

    public void selectFairwellItem(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBoxRefreshmentBdF:
                if (checked) {
                    selection.add("Refreshment");
                } else {
                    selection.remove("Refreshment");
                }
                break;
            case R.id.checkBoxDecorationBdF:
                if (checked) {
                    selection.add("Decoration");
                } else {
                    selection.remove("Decoration");
                }
                break;
            case R.id.checkBoxBdCakeBdF:
                if (checked) {
                    selection.add("Cake");
                } else {
                    selection.remove("Cake");
                }
                break;
            case R.id.checkBoxMusicBdF:
                if (checked) {
                    selection.add("Music");
                } else {
                    selection.remove("Music");
                }
                break;
            case R.id.checkBoxDanGrpBdF:
                if (checked) {
                    selection.add("Dancing Group");
                } else {
                    selection.remove("Dancing Group");
                }
                break;
            case R.id.checkBoxphotoBdF:
                if (checked) {
                    selection.add("Photo / Video");
                } else {
                    selection.remove("Photo / Video");
                }
                break;
            case R.id.checkBoxEquipmentBdF:
                if (checked) {
                    selection.add("Equipment Hire");
                } else {
                    selection.remove("Equipment Hire");
                }
                break;
            case R.id.checkBoxTobaccoBdF:
                if (checked) {
                    selection.add("Tobacco / Alcohol");
                } else {
                    selection.remove("Tobacco / Alcohol");
                }
                break;
            case R.id.checkBoxInvitationBdF:
                if (checked) {
                    selection.add("Invitations");
                } else {
                    selection.remove("Invitations");
                }
                break;
            case R.id.checkBoxOtherBdF:
                if (checked) {
                    selection.add("Other");
                } else {
                    selection.remove("Other");
                }
                break;
        }
    }
}