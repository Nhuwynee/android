package com.example.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ListeningFragment();
            case 1:
                return new ReadingFragment();
            case 2:
                return new TestFragment();
            default:
                return new ListeningFragment();
        }
    }
    @Override
    public int getCount() {
        return 3;
    }
}

