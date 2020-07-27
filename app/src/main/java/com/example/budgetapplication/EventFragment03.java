package com.example.budgetapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EventFragment03 extends Fragment {

    public EventFragment03() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event_fragment03, container, false);

        Button button = (Button) view.findViewById(R.id.addFw);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    case R.id.addFw:
                        Intent intent1 = new Intent(getActivity(), eventListView.class);
                        startActivity(intent1);//Edited here
                        break;


                }
            }
        });
        return view;
    }


}

