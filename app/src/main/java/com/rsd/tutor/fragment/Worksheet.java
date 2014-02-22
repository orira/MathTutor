package com.rsd.tutor.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.rsd.tutor.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Raukawa on 2/16/14.
 */
public class Worksheet extends Fragment {

    @InjectView(R.id.fragment_worksheet_tv_worksheet_number)
    TextView mFragmentWorksheetTvWorksheetNumber;

    @InjectView(R.id.fragment_worksheet_tv_worksheet_category)
    TextView mFragmentWorksheetTvWorksheetCategory;

    @InjectView(R.id.fragment_worksheet_tv_number_of_questions)
    TextView mFragmentWorksheetTvNumberOfQuestions;

    @InjectView(R.id.fragment_worksheet_tv_expected_duration)
    TextView mFragmentWorksheetTvExpectedDuration;

    @InjectView(R.id.fragment_worksheet_bt)
    Button mFragmentWorksheetBt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_worksheet, null);
        ButterKnife.inject(getActivity());

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
