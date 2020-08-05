package com.example.budgetapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.budgetapplication.Models.FamilyExpenseModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FamilyAdapter extends RecyclerView.Adapter<FamilyAdapter.MyViewHolder>{

    Context context;
    private List<FamilyExpenseModel> familyExpenseModelList;

    public FamilyAdapter(Context context, List<FamilyExpenseModel> familyExpenseModelList) {
        this.context = context;
        this.familyExpenseModelList = familyExpenseModelList;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_family,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        FamilyExpenseModel familyExpenseModel = familyExpenseModelList.get(position);
        holder.FamilyItem01.setText(familyExpenseModel.getFamilyExpenseName());
        holder.FamilyPrice01.setText(familyExpenseModel.getFamilyExpenseAmount());
    }

    @Override
    public int getItemCount() {
        return familyExpenseModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView FamilyItem01, FamilyPrice01;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            FamilyItem01 = itemView.findViewById(R.id.FamilyItem01);
            FamilyPrice01 = itemView.findViewById(R.id.FamilyPrice01);
        }
    }
}
