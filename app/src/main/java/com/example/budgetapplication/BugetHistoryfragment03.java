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

public class BugetHistoryfragment03 extends Fragment {

    View v;
    private RecyclerView myreclerview;
    private List<BHFragment03Model> model03;

    public BugetHistoryfragment03() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.budgethistory_fragment03, container,false);

        myreclerview = (RecyclerView) v.findViewById(R.id.recyclerBhEvent);
        RecyclerViewAdapterBhEvent recyclerViewAdapterBhEvent = new RecyclerViewAdapterBhEvent(getContext(),model03);
        myreclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myreclerview.setAdapter(recyclerViewAdapterBhEvent);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model03 = new ArrayList<>();
        model03.add(new BHFragment03Model("Dummy01","DummyDate01","Rs 0000.00"));
        model03.add(new BHFragment03Model("Dummy02","DummyDate02","Rs 0000.00"));
        model03.add(new BHFragment03Model("Dummy03","DummyDate03","Rs 0000.00"));
        model03.add(new BHFragment03Model("Dummy04","DummyDate04","Rs 0000.00"));
        model03.add(new BHFragment03Model("Dummy05","DummyDate05","Rs 0000.00"));
        model03.add(new BHFragment03Model("Dummy06","DummyDate06","Rs 0000.00"));
        model03.add(new BHFragment03Model("Dummy07","DummyDate07","Rs 0000.00"));
        model03.add(new BHFragment03Model("Dummy08","DummyDate08","Rs 0000.00"));
        model03.add(new BHFragment03Model("Dummy09","DummyDate09","Rs 0000.00"));
        model03.add(new BHFragment03Model("Dummy10","DummyDate10","Rs 0000.00"));

    }
}
