package com.example.budgetapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FirebaseViewHolder extends RecyclerView.ViewHolder {

    TextView expenseName,expenseAmount,expenseDate,expenseType;

    public FirebaseViewHolder(@NonNull View itemView) {
        super(itemView);

        expenseName = itemView.findViewById(R.id.ViewExpenseItem01);
        expenseAmount = itemView.findViewById(R.id.ViewExpensePrice01);
        expenseDate = itemView.findViewById(R.id.ViewExpenseDate01);
        expenseType = itemView.findViewById(R.id.ViewBudgetType01);

    }
}
