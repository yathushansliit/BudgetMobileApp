package com.example.budgetapplication;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.budgetapplication.Models.IncomeModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

public class ViewIncomeAdapter extends  RecyclerView.ViewHolder  {

    TextView txtType,txtDate,txtAmount;
    ImageView deleteImg;

    public ViewIncomeAdapter(@NonNull View itemView)  {
        super(itemView);

        txtType = itemView.findViewById(R.id.ViewIncomeType);
        txtDate = itemView.findViewById(R.id.ViewIncomeDate);
        txtAmount = itemView.findViewById(R.id.ViewIncomeAmount);
        deleteImg = itemView.findViewById(R.id.imageView2);


  }







}
