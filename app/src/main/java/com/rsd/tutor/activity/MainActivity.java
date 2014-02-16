package com.rsd.tutor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.rsd.tutor.R;
import com.rsd.tutor.adapter.MainViewPagerAdapter;
import com.rsd.tutor.fragment.CoverFlowFragment;
import com.rsd.tutor.fragment.FragmentName;
import com.rsd.tutor.fragment.FragmentUtil;
import com.rsd.tutor.fragment.transformer.ZoomPageTransformer;
import com.rsd.tutor.util.AnimationUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by wadereweti on 9/02/14.
 */
public class MainActivity extends FragmentActivity implements UserInteraction{

    private static final String TAG = "MainActivity";

    @InjectView(R.id.container)
    LinearLayout mContainer;

    @InjectView(R.id.view_pager_main)
    ViewPager mViewPagerMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initialiseInjection();
        initialiseActionBar();
        initialiseViewPager();
    }

    private void initialiseInjection() {
        ButterKnife.inject(this);
    }

    private void initialiseActionBar() {
        getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.base_accent));
    }

    private void initialiseViewPager() {
        List<Fragment> fragments = initialiseFragments();
        final float SCALE_FACTOR  = 0.7f;

        mViewPagerMain.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager(), fragments));
        mViewPagerMain.setOffscreenPageLimit(2);
        mViewPagerMain.setPageMargin(getResources().getInteger(R.integer.margin_view_pager));
        mViewPagerMain.setPageTransformer(false, new ZoomPageTransformer());
    }

    private List<Fragment> initialiseFragments() {
        List<Fragment> fragments = new ArrayList<Fragment>();

        for(int i=0; i<3; i++) {
            fragments.add(new CoverFlowFragment(this, i));
        }

        return fragments;
    }

    @Override
    public void workItemSelected(int position) {
        Intent intent = new Intent(this, FragmentUtil.getDestinationActivity(position));
        startActivity(intent);
    }
}
