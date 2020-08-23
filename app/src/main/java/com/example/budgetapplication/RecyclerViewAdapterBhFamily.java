package com.example.budgetapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapterBhFamily extends RecyclerView.ViewHolder {
    TextView tv_item,tv_Date,tv_price;

    public RecyclerViewAdapterBhFamily(@NonNull View itemView) {
        super(itemView);

        tv_item = itemView.findViewById(R.id.BudgetHistoryFmItem01);
        tv_Date = itemView.findViewById(R.id.BudgetHistoryFmDate01);
        tv_price =itemView.findViewById(R.id.BudgetHistoryFmPrice01);
    }
}
