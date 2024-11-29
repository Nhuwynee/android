package com.example.yennhu;

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
                return new LoginFragment();
            case 1:
                return new HomeFragment();
            case 2:
                return new ProfileFragment();
            default:
                return new LoginFragment();
        }
    }
    @Override
    public int getCount() {
        return 3;
    }
}

