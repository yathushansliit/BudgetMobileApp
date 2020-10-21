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

public class EventOther extends AppCompatActivity {

    EditText txtAmount,txtCrowd;
    Button btn,btnCAncel;
    ArrayList<String> selection = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_other);


        txtAmount = findViewById(R.id.AmountBdOther);
        txtCrowd = findViewById(R.id.CrowdBdOther);
        btn = findViewById(R.id.addOther);
        btnCAncel = findViewById(R.id.cancelOther);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String amt =txtAmount.getText().toString().trim();
                final String crd =txtCrowd.getText().toString().trim();
                if (TextUtils.isEmpty(amt) ){
                    txtAmount.setError("Event amount is required.");
                }

                else if (TextUtils.isEmpty(crd)){
                    txtCrowd.setError("Birthday Crowd is required.");
                }

                else {
                    Intent intent = new Intent(EventOther.this, EventOtherListView.class);
                    intent.putExtra("selectedoTHERItems", selection);
                    intent.putExtra("oTHERAmount", txtAmount.getText().toString());
                    intent.putExtra("Othercrowd", txtCrowd.getText().toString());
                    startActivity(intent);
                }
            }
        });

        btnCAncel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
    }
    public void selectOtherItem(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBoxRefreshmentBdO:
                if (checked) {
                    selection.add("Refreshment");
                } else {
                    selection.remove("Refreshment");
                }
                break;
            case R.id.checkBoxDecorationBdO:
                if (checked) {
                    selection.add("Decoration");
                } else {
                    selection.remove("Decoration");
                }
                break;
            case R.id.checkBoxBdCakeBdO:
                if (checked) {
                    selection.add("Cake");
                } else {
                    selection.remove("Cake");
                }
                break;
            case R.id.checkBoxMusicBdO:
                if (checked) {
                    selection.add("Music");
                } else {
                    selection.remove("Music");
                }
                break;
            case R.id.checkBoxDanGrpBdO:
                if (checked) {
                    selection.add("Dancing Group");
                } else {
                    selection.remove("Dancing Group");
                }
                break;
            case R.id.checkBoxphotoBdO:
                if (checked) {
                    selection.add("Photo / Video");
                } else {
                    selection.remove("Photo / Video");
                }
                break;
            case R.id.checkBoxEquipmentBdO:
                if (checked) {
                    selection.add("Equipment Hire");
                } else {
                    selection.remove("Equipment Hire");
                }
                break;
            case R.id.checkBoxTobaccoBdO:
                if (checked) {
                    selection.add("Tobacco / Alcohol");
                } else {
                    selection.remove("Tobacco / Alcohol");
                }
                break;
            case R.id.checkBoxInvitationBdO:
                if (checked) {
                    selection.add("Invitations");
                } else {
                    selection.remove("Invitations");
                }
                break;
            case R.id.checkBoxOtherBdO:
                if (checked) {
                    selection.add("Other");
                } else {
                    selection.remove("Other");
                }
                break;
        }
    }
}