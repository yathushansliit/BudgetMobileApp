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

public class EventBirthday extends AppCompatActivity {

    EditText txtAmount,txtCrowd;
    Button btn,btnCancel;
    ArrayList<String> selection = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_birthday);

        btn = findViewById(R.id.addBirthday);
        txtAmount = findViewById(R.id.AmountBd);
        txtCrowd = findViewById(R.id.CrowdBd);
        btnCancel = findViewById(R.id.bDAycancel);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String amt =txtAmount.getText().toString().trim();
                final String crd =txtCrowd.getText().toString().trim();
                if (TextUtils.isEmpty(amt)) {
                    txtAmount.setError("Birthday amount is required.");
                }

                else if (TextUtils.isEmpty(crd)){
                    txtCrowd.setError("Birthday Crowd is required.");
                }
                else
                    {
                Intent intent = new Intent(EventBirthday.this, eventListView.class);
                intent.putExtra("selectedBdItems", selection);
                intent.putExtra("BirthdayAmount", txtAmount.getText().toString());
                intent.putExtra("EventType", "Birthday");
                intent.putExtra("crowd", txtCrowd.getText().toString());
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

    public void selectBirthdayItem(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBoxRefreshmentBd:
                if (checked) {
                    selection.add("Refreshment");
                } else {
                    selection.remove("Refreshment");
                }
                break;
            case R.id.checkBoxDecorationBd:
                if (checked) {
                    selection.add("Decoration");
                } else {
                    selection.remove("Decoration");
                }
                break;
            case R.id.checkBoxBdCakeBd:
                if (checked) {
                    selection.add("Cake");
                } else {
                    selection.remove("Cake");
                }
                break;
            case R.id.checkBoxMusicBd:
                if (checked) {
                    selection.add("Music");
                } else {
                    selection.remove("Music");
                }
                break;
            case R.id.checkBoxDanGrpBd:
                if (checked) {
                    selection.add("Dancing Group");
                } else {
                    selection.remove("Dancing Group");
                }
                break;
            case R.id.checkBoxphotoBd:
                if (checked) {
                    selection.add("Photo / Video");
                } else {
                    selection.remove("Photo / Video");
                }
                break;
            case R.id.checkBoxEquipmentBd:
                if (checked) {
                    selection.add("Equipment Hire");
                } else {
                    selection.remove("Equipment Hire");
                }
                break;
            case R.id.checkBoxTobaccoBd:
                if (checked) {
                    selection.add("Tobacco / Alcohol");
                } else {
                    selection.remove("Tobacco / Alcohol");
                }
                break;
            case R.id.checkBoxInvitationBd:
                if (checked) {
                    selection.add("Invitations");
                } else {
                    selection.remove("Invitations");
                }
                break;
            case R.id.checkBoxOtherBd:
                if (checked) {
                    selection.add("Other");
                } else {
                    selection.remove("Other");
                }
                break;
        }
    }
}