package com.rsd.tutor.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.rsd.tutor.R;
import com.rsd.tutor.adapter.WorksheetAssessmentPagerAdapter;

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
        WorksheetAssessmentPagerAdapter adapter = new WorksheetAssessmentPagerAdapter(getSupportFragmentManager(), initialiseFragments());
        mViewPager.setAdapter(adapter);
    }

    private List<Fragment> initialiseFragments() {
        return null;
    }
}
