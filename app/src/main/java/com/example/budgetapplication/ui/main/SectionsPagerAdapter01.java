package com.example.budgetapplication.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.budgetapplication.AddtoBudgetFragment01;
import com.example.budgetapplication.AddtoBudgetFragment02;
import com.example.budgetapplication.AddtoBudgetFragment03;

import com.example.budgetapplication.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter01 extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_4, R.string.tab_text_5, R.string.tab_text_6};
    private final Context mContext;

    public SectionsPagerAdapter01(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
      Fragment fragment = null;

      switch (position){
          case 0:
              fragment = new AddtoBudgetFragment01();
              break;
          case 1:
              fragment = new AddtoBudgetFragment02();
              break;
          case 2:
              fragment = new AddtoBudgetFragment03();
              break;

      }
      return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}