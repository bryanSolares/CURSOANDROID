package com.example.tabexperiment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int noTabs;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm);
        this.noTabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new TabFragment1();
            case 1: return new TagFragment2();
            case 2: return new TagFragment3();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return noTabs;
    }
}
