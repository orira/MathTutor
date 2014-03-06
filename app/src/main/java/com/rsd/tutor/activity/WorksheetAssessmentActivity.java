package com.rsd.tutor.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.rsd.tutor.R;
import com.rsd.tutor.adapter.WorksheetPagerAdapter;
import com.rsd.tutor.fragment.WorksheetPreviewFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Raukawa on 2/16/14.
 */
public class WorksheetAssessmentActivity extends FragmentActivity {

    @InjectView(R.id.activity_worksheet_assessment_view_pager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_worksheet_assessment);

        initialiseInjection();
        setupViewPager();
    }

    private void initialiseInjection() {
        ButterKnife.inject(this);
    }

    private void setupViewPager() {
        WorksheetPagerAdapter adapter = new WorksheetPagerAdapter(getSupportFragmentManager(), initialiseFragments());
        mViewPager.setAdapter(adapter);
    }

    private List<Fragment> initialiseFragments() {
        List<Fragment> fragments = new ArrayList<Fragment>();
        //fragments.add(new WorksheetPreviewFragment());

        return fragments;
    }
}
