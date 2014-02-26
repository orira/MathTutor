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

    @Override
    public float getPageWidth(int position) {
        float fragmentWidth;

        boolean evenNumberOfFragments = false;
        if (mFragments.size() % 2 == 0) {
            evenNumberOfFragments = true;
        }

        // get second to last fragment as we've added a dummy fragment in
        if (position == mFragments.size() - 2 && evenNumberOfFragments) {
            fragmentWidth = .5f;
        } else if (position == 0 && evenNumberOfFragments) {
            // Dummy fragment at start of pager set width to a fifth so pagers line up nicely
            fragmentWidth = .2f;
        } else {
            fragmentWidth = .6f;
        }

        return fragmentWidth;
    }
}
