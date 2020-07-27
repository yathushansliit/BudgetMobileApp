package com.example.budgetapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {


    String data1[], data2[];
    Context context;

    public  EventAdapter(Context ct,String s1[], String s2[]){
        context = ct;
        data1 = s1;
        data2 = s2;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_event,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.EventItem01.setText(data1[position]);
        holder.EventPrice01.setText(data2[position]);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView EventItem01, EventPrice01;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            EventItem01 = itemView.findViewById(R.id.EventItem01);
            EventPrice01 = itemView.findViewById(R.id.EventPrice01);

        }
    }
}
