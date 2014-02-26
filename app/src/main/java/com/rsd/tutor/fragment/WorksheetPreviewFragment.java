package com.rsd.tutor.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rsd.tutor.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Raukawa on 2/25/14.
 */
public class WorksheetPreviewFragment extends Fragment {

    @InjectView(R.id.fragment_preview_worksheet_id)
    TextView mWorksheetId;

    @InjectView(R.id.fragment_preview_worksheet_lesson_category)
    TextView mLessonCategory;

    @InjectView(R.id.fragment_preview_worksheet_number_of_questions)
    TextView mNumberOfQuestions;

    @InjectView(R.id.fragment_preview_worksheet_difficulty)
    TextView mDifficulty;

    @InjectView(R.id.fragment_preview_worksheet_status)
    TextView mStatus;

    @InjectView(R.id.fragment_preview_worksheet_time_taken)
    TextView mTimeTaken;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_worksheet_preview, null);
        ButterKnife.inject(this, view);

        return view;
    }
}
