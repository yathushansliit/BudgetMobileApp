package com.example.budgetapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.budgetapplication.Models.EventModel;
import com.example.budgetapplication.Models.IndividualExpenseModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {

    Context context;
    private List<EventModel> eventExpenseModelList;

    public EventAdapter(Context context, List<EventModel> eventExpenseModelList) {
        this.context = context;
        this.eventExpenseModelList = eventExpenseModelList;
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
        EventModel eventModel = eventExpenseModelList.get(position);
        holder.EventItem01.setText(eventModel.getEventExpenseName());
        holder.EventPrice01.setText(eventModel.getEventExpenseAmount());
    }

    @Override
    public int getItemCount() {
        return eventExpenseModelList.size();
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
