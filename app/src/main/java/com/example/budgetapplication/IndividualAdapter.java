package com.example.budgetapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.budgetapplication.Models.IndividualExpenseModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class IndividualAdapter extends RecyclerView.Adapter<IndividualAdapter.MyViewHolder> {

    Context context;
    private List<IndividualExpenseModel> individualExpenseModelList;

    public  IndividualAdapter(Context ct,List<IndividualExpenseModel> individualExpenseModelList){
        context = ct;
        this.individualExpenseModelList = individualExpenseModelList;
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
        IndividualExpenseModel individualExpenseModel = individualExpenseModelList.get(position);
        holder.IndividualExpenseName.setText(individualExpenseModel.getIndividualExpenseName());
        holder.IndividualExpenseAmount.setText(individualExpenseModel.getIndividualExpenseAmount());
    }

    @Override
    public int getItemCount() {
        return individualExpenseModelList.size();
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
