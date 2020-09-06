package com.example.budgetapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class BudgetHistoryListView extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private BudgetHistoryViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_history);


        tabLayout = (TabLayout) findViewById(R.id.tabsBH);
        viewPager  =  (ViewPager)  findViewById(R.id.view_pagerBH);
        adapter    =  new BudgetHistoryViewPagerAdapter(getSupportFragmentManager());

        //Add Fragments here
        adapter.AddFragment(new BugetHistoryfragment01(),"Individual");
        adapter.AddFragment(new BugetHistoryfragment02(),"Family");
        adapter.AddFragment(new BugetHistoryfragment03(),"Event");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}