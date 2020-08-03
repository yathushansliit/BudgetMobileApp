package com.example.budgetapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.budgetapplication.ExpenseModels.IndividualExpense;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class IndividualAdapter extends RecyclerView.Adapter<IndividualAdapter.MyViewHolder> {

    Context context;
    private List<IndividualExpense> individualExpenseList;

    public  IndividualAdapter(Context ct,List<IndividualExpense> individualExpenseList){
        context = ct;
        this.individualExpenseList = individualExpenseList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_individual,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        IndividualExpense individualExpense = individualExpenseList.get(position);
        holder.IndividualExpenseName.setText(individualExpense.getIndividualExpenseName());
        holder.IndividualExpenseAmount.setText(individualExpense.getIndividualExpenseAmount());
    }

    @Override
    public int getItemCount() {
        return individualExpenseList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView IndividualExpenseName, IndividualExpenseAmount;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            IndividualExpenseName = itemView.findViewById(R.id.IndividualItem01);
            IndividualExpenseAmount = itemView.findViewById(R.id.IndividualPrice01);
        }
    }
}
