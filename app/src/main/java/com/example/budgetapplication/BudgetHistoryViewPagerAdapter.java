package com.example.budgetapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class BudgetHistoryViewPagerAdapter extends FragmentPagerAdapter {

    private  final List<Fragment> fragment01 = new ArrayList<>();
    private final  List<String>   title01    = new ArrayList<>();

    public BudgetHistoryViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragment01.get(position);
    }

    @Override
    public int getCount() {
        return title01.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title01.get(position);
    }


    public void AddFragment (Fragment fragment,String title){

        fragment01.add(fragment);
        title01.add(title);
    }
}
