package com.example.budgetapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewExpenseAdapter extends RecyclerView.Adapter<ViewExpenseAdapter.MyViewHolder> {

    String data1[], data2[], data3[];
     Context context;





    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_view_expense,parent,false);
      return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {

      TextView expenseName,expenseAmount,expenseDate,expenseType;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            expenseName = itemView.findViewById(R.id.ViewExpenseItem01);
            expenseAmount = itemView.findViewById(R.id.ViewExpensePrice01);
            expenseDate = itemView.findViewById(R.id.ViewExpenseDate01);
            expenseType = itemView.findViewById(R.id.ViewBudgetType01);

        }
    }
}
