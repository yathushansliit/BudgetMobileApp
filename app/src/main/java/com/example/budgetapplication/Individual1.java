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

public class Individual1 extends AppCompatActivity {

    Button button,btn1;
    EditText txtAmount;
    ArrayList<String> selection = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual1);


        button = findViewById(R.id.add);
        btn1 = findViewById(R.id.individualcancel);
        txtAmount = findViewById(R.id.Amount);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String amt =txtAmount.getText().toString().trim();
                if (TextUtils.isEmpty(amt)){
                    txtAmount.setError("Budget amount is required.");
                    return;
                }
                else
                    {
                    Intent intent = new Intent(Individual1.this, IndividualListView.class);
                    intent.putExtra("selectedItems",selection);
                    intent.putExtra("amount", txtAmount.getText().toString());
                    startActivity(intent);
                    }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    public void selectItem(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBoxFood:
                if (checked) {
                    selection.add("Food");
                } else {
                    selection.remove("Food");
                }
                break;
            case R.id.checkBoxHomeR:
                if (checked) {
                    selection.add("Home Repair");
                } else {
                    selection.remove("Home Repair");
                }
                break;
            case R.id.checkBoxTransport:
                if (checked) {
                    selection.add("Transport");
                } else {
                    selection.remove("Transport");
                }
                break;
            case R.id.checkBoxVehicleM:
                if (checked) {
                    selection.add("Vehicle Maintenance");
                } else {
                    selection.remove("Vehicle Maintenance");
                }
                break;
            case R.id.checkBoxEducation:
                if (checked) {
                    selection.add("Education");
                } else {
                    selection.remove("Education");
                }
                break;
            case R.id.checkBoxEntertainment:
                if (checked) {
                    selection.add("Entertainment");
                } else {
                    selection.remove("Entertainment");
                }
                break;
            case R.id.checkBoxClothing:
                if (checked) {
                    selection.add("Clothing");
                } else {
                    selection.remove("Clothing");
                }
                break;
            case R.id.checkBoxTobacco:
                if (checked) {
                    selection.add("Alchohol / Tobacco");
                } else {
                    selection.remove("Alchohol / Tobacco");
                }
                break;
            case R.id.checkBoxHealth:
                if (checked) {
                    selection.add("Health Care");
                } else {
                    selection.remove("Health Care");
                }
                break;
            case R.id.checkBoxSports:
                if (checked) {
                    selection.add("Sports");
                } else {
                    selection.remove("Sports");
                }
                break;
            case R.id.checkBoxGlossaries:
                if (checked) {
                    selection.add("Glossaries");
                } else {
                    selection.remove("Glossaries");
                }
                break;
            case R.id.checkBoxSaloonService:
                if (checked) {
                    selection.add("Saloon Service");
                } else {
                    selection.remove("Saloon Service");
                }
                break;
            case R.id.checkBoxUtility:
                if (checked) {
                    selection.add("Utility Bills");
                } else {
                    selection.remove("Utility Bills");
                }
                break;
            case R.id.checkBoxMagazines:
                if (checked) {
                    selection.add("Magazines");
                } else {
                    selection.remove("Magazines");
                }
                break;
            case R.id.checkBoxRent:
                if (checked) {
                    selection.add("Rent");
                } else {
                    selection.remove("Rent");
                }
                break;
            case R.id.checkBoxOccasions:
                if (checked) {
                    selection.add("Occasions");
                } else {
                    selection.remove("Occasions");
                }
                break;
            case R.id.checkBoxProperty:
                if (checked) {
                    selection.add("Property Tax");
                } else {
                    selection.remove("Property Tax");
                }
                break;
            case R.id.checkBoxDonations:
                if (checked) {
                    selection.add("Donations");
                } else {
                    selection.remove("Donations");
                }
                break;
            case R.id.checkBoxVacation:
                if (checked) {
                    selection.add("Vacation");
                } else {
                    selection.remove("Vacation");
                }
                break;
            case R.id.checkBoxVehicleIn:
                if (checked) {
                    selection.add("Vehicle Insurance");
                } else {
                    selection.remove("Vehicle Insurance");
                }
                break;
            case R.id.checkBoxLoan:
                if (checked) {
                    selection.add("Loan Payment");
                } else {
                    selection.remove("Loan Payment");
                }
                break;
            case R.id.checkBoxInsurance:
                if (checked) {
                    selection.add("Insurance");
                } else {
                    selection.remove("Insurance");
                }
                break;

        }
    }
}