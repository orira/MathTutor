package com.rsd.tutor.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rsd.tutor.R;
import com.rsd.tutor.custom.RobotoBoldTextView;
import com.rsd.tutor.custom.RobotoThinTextView;
import com.rsd.tutor.persistence.domain.Question;
import com.rsd.tutor.persistence.domain.Worksheet;
import com.rsd.tutor.util.DateUtil;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Raukawa on 2/25/14.
 */
public class WorksheetPreviewFragment extends Fragment {

    private static final String PARCELABLE_NAME = "worksheet";

    private Worksheet mWorksheet;

    @InjectView(R.id.fragment_preview_question)
    TextView mQuestion;

    @InjectView(R.id.fragment_preview_worksheet_id)
    RobotoThinTextView mWorksheetId;

    @InjectView(R.id.fragment_preview_worksheet_number_of_questions)
    TextView mNumberOfQuestions;

    @InjectView(R.id.fragment_preview_worksheet_duration)
    TextView mDuration;

    @InjectView(R.id.fragment_preview_worksheet_lesson_category)
    RobotoBoldTextView mLessonCategory;

    @InjectView(R.id.fragment_preview_worksheet_difficulty)
    TextView mDifficulty;

    @InjectView(R.id.fragment_preview_worksheet_assigned)
    TextView mAssigned;

    @InjectView(R.id.fragment_preview_worksheet_status)
    TextView mStatus;

    @InjectView(R.id.fragment_preview_worksheet_time_taken)
    TextView mTimeTaken;

    @InjectView(R.id.fragment_preview_worksheet_bt)
    ImageButton mButton;

    public static WorksheetPreviewFragment newInstance(Worksheet worksheet) {
        WorksheetPreviewFragment fragment = new WorksheetPreviewFragment();
        Bundle args = new Bundle();
        args.putParcelable(PARCELABLE_NAME, worksheet);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            mWorksheet = args.getParcelable(PARCELABLE_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_worksheet_preview, null);
        ButterKnife.inject(this, view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        Question firstQuestion = mWorksheet.questions().get(0);
        mQuestion.setText(firstQuestion.detail);
        mWorksheetId.setText(mWorksheet.worksheetId);
        // TODO: Align title and category
        mLessonCategory.setText(mWorksheet.title);
        mNumberOfQuestions.setText(Integer.toString(mWorksheet.questions().size()));
        mDuration.setText(DateUtil.formatTime(mWorksheet.duration));
        mDifficulty.setText(mWorksheet.difficultyLevel.getDisplayName());
        mAssigned.setText(DateUtil.formatStandardDate(mWorksheet.assignedDate));
        mStatus.setText(mWorksheet.status.getDisplayName());
        mTimeTaken.setText(DateUtil.formatTime(mWorksheet.d));
    }
}
