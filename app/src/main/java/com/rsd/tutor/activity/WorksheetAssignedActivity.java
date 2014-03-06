package com.rsd.tutor.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.rsd.tutor.R;
import com.rsd.tutor.adapter.WorksheetPagerAdapter;
import com.rsd.tutor.fragment.DummyFragment;
import com.rsd.tutor.fragment.WorksheetPreviewFragment;
import com.rsd.tutor.fragment.transformer.ZoomPageTransformer;
import com.rsd.tutor.module.Service;
import com.rsd.tutor.module.WorksheetServiceModule;
import com.rsd.tutor.persistence.SharedPrefs;
import com.rsd.tutor.persistence.WorksheetStatus;
import com.rsd.tutor.persistence.domain.Worksheet;
import com.rsd.tutor.service.WorksheetService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.ButterKnife;
import butterknife.InjectView;
import dagger.ObjectGraph;

/**
 * Created by Raukawa on 2/16/14.
 */
public class WorksheetAssignedActivity extends AbstractActivity implements WorksheetRequest {

    @Inject
    @Named(Service.WORKSHEET_STUB)
    WorksheetService mWorksheetService;

    @InjectView(R.id.activity_worksheet_assigned_view_pager)
    ViewPager mViewPager;

    private List<Worksheet> mWorksheets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_worksheet_assigned);

        initialiseInjection();
        getWorksheets();
        initialiseViewPager();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void initialiseViewPager() {
        WorksheetPagerAdapter adapter = new WorksheetPagerAdapter(getSupportFragmentManager(), initialiseFragments());
        mViewPager.setAdapter(adapter);
        mViewPager.setPageMargin(100);
        mViewPager.setPageTransformer(false, new ZoomPageTransformer());
    }

    private List<Fragment> initialiseFragments() {
        List<Fragment> fragments = new ArrayList<Fragment>();

        if (!checkFirstTimeUser()) {
            //fragments.add(new WorksheetPreviewFragment());
        } else {
            for (Worksheet worksheet: mWorksheets) {
                fragments.add(WorksheetPreviewFragment.newInstance(worksheet));
            }

            fragments.add(new DummyFragment());
        }

        return fragments;
    }

    @Override
    protected void asyncTaskComplete(boolean result) {

    }

    private void initialiseInjection() {
        ButterKnife.inject(this);
        ObjectGraph.create(new WorksheetServiceModule()).inject(this);
    }

    private void getWorksheets() {
        mWorksheets = mWorksheetService.getWorksheetsFromDb(this, WorksheetStatus.ASSIGNED);
    }

    private boolean checkFirstTimeUser() {
        SharedPreferences sharedPreferences = getSharedPreferences(SharedPrefs.SETTINGS, Activity.MODE_PRIVATE);

        return sharedPreferences.getBoolean(SharedPrefs.FIRST_TIME_USER, true);
    }

    @Override
    public void setWorksheets(List<Worksheet> worksheets) {
        mWorksheets = worksheets;
    }
}
