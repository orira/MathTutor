package com.rsd.tutor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.rsd.tutor.R;
import com.rsd.tutor.adapter.MainViewPagerAdapter;
import com.rsd.tutor.fragment.CoverFlowFragment;
import com.rsd.tutor.fragment.FragmentUtil;
import com.rsd.tutor.fragment.transformer.ZoomPageTransformer;
import com.rsd.tutor.widget.SpanBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by wadereweti on 9/02/14.
 */
public class MainActivity extends BaseActivity implements UserInteraction{

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
        initialiseViewPager();
    }

    @Override
    protected void onStart() {
        super.onStart();
        animateActionBarTitle();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void initialiseInjection() {
        ButterKnife.inject(this);
    }

    private void initialiseViewPager() {
        List<Fragment> fragments = initialiseFragments();

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

    private void animateActionBarTitle() {
        new SpanBuilder(this).runFireworksAnimation();
    }

    @Override
    public void workItemSelected(int position) {
        Intent intent = new Intent(this, FragmentUtil.getDestinationActivity(position));
        startActivity(intent);
    }

    @Override
    public boolean isCurrentPosition(int position) {
        return mViewPagerMain.getCurrentItem() == position;
    }
}
