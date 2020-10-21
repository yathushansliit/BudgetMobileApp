package com.example.budgetapplication;

import android.os.Bundle;

import com.example.budgetapplication.ui.main.SectionsPagerAdapter01;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

public class AddToBudgetTab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_budget_tab);
        SectionsPagerAdapter01 sectionsPagerAdapter01 = new SectionsPagerAdapter01(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter01);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);



    }
}