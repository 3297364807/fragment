package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class AppFragmentPageAdapter extends FragmentPagerAdapter {
    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    List<Fragment> fragments;
    public AppFragmentPageAdapter(@NonNull FragmentManager fm) {
        super(fm);

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
