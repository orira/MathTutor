package com.rsd.tutor.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rsd.tutor.R;
import com.rsd.tutor.activity.UserInteraction;
import com.rsd.tutor.util.TransitionAnimationUtil;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Raukawa on 2/16/14.
 */
public class CoverFlowFragment extends Fragment {

    private UserInteraction mUserInteraction;
    private int mPosition;

    @InjectView(R.id.fragment_cover_flow_container)
    RelativeLayout mFragmentCoverFlowContainer;

    @InjectView(R.id.fragment_cover_flow_tv_title_book)
    TextView mTitleBook;

    public CoverFlowFragment() {}

    public CoverFlowFragment(UserInteraction userInteraction, int position) {
        mUserInteraction = userInteraction;
        mPosition = position;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cover_flow, null);
        ButterKnife.inject(this, view);
        initialiseView();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    private void initialiseView() {
        mTitleBook.setText(FragmentUtil.getBookTitle(mPosition, getActivity()));
    }

    /**
     * Scale view down with an overshoot interpolator then call
     * back to parent to run Intent to correct @Link(Activity)
     */
    @OnClick(R.id.fragment_cover_flow_iv_book)
    public void handleClick(final View view) {
        if (mUserInteraction.isCurrentPosition(mPosition)) {
            //TransitionAnimationUtil.runOvershootAnimationOnClick(mFragmentCoverFlowContainer, mUserInteraction, mPosition);
            int rotationValue = view.getRotationY() == 0 ? -180 : 0;
            //view.animate().setDuration(5000).rotationY(rotationValue);
            view.animate().setDuration(5000).rotationYBy(180);
        }
    }
}
