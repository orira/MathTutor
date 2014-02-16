package com.rsd.tutor.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rsd.tutor.R;
import com.rsd.tutor.activity.UserInteraction;
import com.rsd.tutor.util.AnimationUtil;
import com.rsd.tutor.util.TypeValueUtil;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Raukawa on 2/16/14.
 */
public class CoverFlowFragment extends Fragment {

    final private UserInteraction mUserInteraction;
    final private int mPosition;

    @InjectView(R.id.title_book)
    TextView mTitleBook;

    public CoverFlowFragment(UserInteraction userInteraction, int position) {
        mUserInteraction = userInteraction;
        mPosition = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cover_flow, null);
        ButterKnife.inject(this, view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        initialiseView();
    }

    private void initialiseView() {
        mTitleBook.setText(FragmentUtil.getBookTitle(mPosition, getActivity()));
    }

    /**
     * Scale view down with an overshoot interpolator then call back to parent to run
     * Intent to correct @Link(Activity)
     */
    @OnClick(R.id.container_fragment_cover_flow)
    public void handleClick(final View view) {
        AnimationUtil.runOvershootAnimationOnClick(view, mUserInteraction, mPosition);
    }
}
