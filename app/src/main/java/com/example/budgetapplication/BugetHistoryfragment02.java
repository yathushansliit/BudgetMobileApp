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

public class BugetHistoryfragment02 extends Fragment {

    View v;
    private RecyclerView myreclerview;
    private List<BHFragment02Model> model02;

    public BugetHistoryfragment02() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.budgethistory_fragment02, container,false);

        myreclerview = (RecyclerView) v.findViewById(R.id.recyclerBhFamily);
        RecyclerViewAdapterBhFamily recyclerViewAdapterBhFamily = new RecyclerViewAdapterBhFamily(getContext(),model02);
        myreclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myreclerview.setAdapter(recyclerViewAdapterBhFamily);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model02 = new ArrayList<>();
        model02.add(new BHFragment02Model("Dummy01","DummyDate01","Rs 0000.00"));
        model02.add(new BHFragment02Model("Dummy02","DummyDate02","Rs 0000.00"));
        model02.add(new BHFragment02Model("Dummy03","DummyDate03","Rs 0000.00"));
        model02.add(new BHFragment02Model("Dummy04","DummyDate04","Rs 0000.00"));
        model02.add(new BHFragment02Model("Dummy05","DummyDate05","Rs 0000.00"));
        model02.add(new BHFragment02Model("Dummy06","DummyDate06","Rs 0000.00"));
        model02.add(new BHFragment02Model("Dummy07","DummyDate07","Rs 0000.00"));
        model02.add(new BHFragment02Model("Dummy08","DummyDate08","Rs 0000.00"));
        model02.add(new BHFragment02Model("Dummy09","DummyDate09","Rs 0000.00"));
        model02.add(new BHFragment02Model("Dummy10","DummyDate10","Rs 0000.00"));

    }

}
