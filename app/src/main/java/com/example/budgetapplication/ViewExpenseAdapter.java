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


  public ViewExpenseAdapter(Context ct, String s1[], String s2[], String s3[]){
      context = ct;
      data1 = s1;
      data2 = s2;
      data3 = s3;

  }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_view_expense,parent,false);
      return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

      holder.textView1.setText(data1[position]);
        holder.textView2.setText(data2[position]);
        holder.textView3.setText(data3[position]);

    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {

      TextView textView1,textView2,textView3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.ViewExpenseItem01);
            textView2 = itemView.findViewById(R.id.ViewExpensePrice01);
            textView3 = itemView.findViewById(R.id.ViewExpenseDate01);

        }
    }
}