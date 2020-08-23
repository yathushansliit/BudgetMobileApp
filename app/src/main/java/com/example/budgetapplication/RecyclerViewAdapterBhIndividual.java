package com.example.budgetapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.budgetapplication.Models.IndividualBudgetModel;
import com.example.budgetapplication.Models.IndividualExpenseModel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapterBhIndividual extends RecyclerView.ViewHolder {


    TextView tv_item,tv_Date,tv_price;


    public RecyclerViewAdapterBhIndividual(@NonNull View itemView) {
        super(itemView);
          tv_item =  itemView.findViewById(R.id.BudgetHistoryInItem01);
          tv_Date = itemView.findViewById(R.id.BudgetHistoryInDate01);
          tv_price =  itemView.findViewById(R.id.BudgetHistoryInPrice01);

    }
}
