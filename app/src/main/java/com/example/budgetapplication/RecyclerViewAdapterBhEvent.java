package com.example.budgetapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapterBhEvent extends RecyclerView.Adapter<RecyclerViewAdapterBhEvent.MyViewHolder> {


    Context mcontext;
    List<BHFragment03Model> mData;

    public RecyclerViewAdapterBhEvent(Context mcontext, List<BHFragment03Model> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mcontext).inflate(R.layout.my_row_budgethistory_event,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_item.setText(mData.get(position).getBhItem());
        holder.tv_price.setText(mData.get(position).getBhPrice());
        holder.tv_Date.setText(mData.get(position).getBhDate());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_item;
        private TextView tv_Date;
        private TextView tv_price;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_item = (TextView) itemView.findViewById(R.id.BudgetHistoryEvItem01);
            tv_Date = (TextView) itemView.findViewById(R.id.BudgetHistoryEvDate01);
            tv_price = (TextView) itemView.findViewById(R.id.BudgetHistoryEvPrice01);
        }
    }
}
