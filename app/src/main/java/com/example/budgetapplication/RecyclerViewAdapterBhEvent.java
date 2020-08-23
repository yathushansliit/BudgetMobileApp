package com.example.budgetapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapterBhEvent extends RecyclerView.ViewHolder {
    TextView tv_item,tv_Date,tv_price;

    public RecyclerViewAdapterBhEvent(@NonNull View itemView) {
        super(itemView);

        tv_item = itemView.findViewById(R.id.BudgetHistoryEvItem01);
        tv_Date = itemView.findViewById(R.id.BudgetHistoryEvDate01);
        tv_price =itemView.findViewById(R.id.BudgetHistoryEvPrice01);
    }
}
