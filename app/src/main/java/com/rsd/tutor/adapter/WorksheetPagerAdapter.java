package com.rsd.tutor.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Raukawa on 2/25/14.
 */
public class WorksheetPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public WorksheetPagerAdapter(FragmentManager fragmentManager, List<Fragment> fragments) {
        super(fragmentManager);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
