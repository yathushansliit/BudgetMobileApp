package com.example.budgetapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BugetHistoryfragment01 extends Fragment {

    View v;
    private RecyclerView myreclerview;
    private List<BHFragment01Model> model01;

    public BugetHistoryfragment01() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.budgethistory_fragment01, container,false);
        myreclerview = (RecyclerView) v.findViewById(R.id.recyclerBhIndividual);
        RecyclerViewAdapterBhIndividual recyclerViewAdapterBhIndividual = new RecyclerViewAdapterBhIndividual(getContext(),model01);
        myreclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myreclerview.setAdapter(recyclerViewAdapterBhIndividual);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model01 = new ArrayList<>();
        model01.add(new BHFragment01Model("Dummy01","DummyDate01","Rs 0000.00"));
        model01.add(new BHFragment01Model("Dummy02","DummyDate02","Rs 0000.00"));
        model01.add(new BHFragment01Model("Dummy03","DummyDate03","Rs 0000.00"));
        model01.add(new BHFragment01Model("Dummy04","DummyDate04","Rs 0000.00"));
        model01.add(new BHFragment01Model("Dummy05","DummyDate05","Rs 0000.00"));
        model01.add(new BHFragment01Model("Dummy06","DummyDate06","Rs 0000.00"));
        model01.add(new BHFragment01Model("Dummy07","DummyDate07","Rs 0000.00"));
        model01.add(new BHFragment01Model("Dummy08","DummyDate08","Rs 0000.00"));
        model01.add(new BHFragment01Model("Dummy09","DummyDate09","Rs 0000.00"));
        model01.add(new BHFragment01Model("Dummy10","DummyDate10","Rs 0000.00"));

    }
}
