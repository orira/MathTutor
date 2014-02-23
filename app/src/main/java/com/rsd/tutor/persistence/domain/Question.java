package com.rsd.tutor.persistence.domain;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.rsd.tutor.dto.QuestionDto;

import java.util.List;

/**
 * Created by wadereweti on 10/02/14.
 */
@Table(name = "Question")
public class Question extends Model {
    private static final String TAG = "Question";
    private static final String DETAIL = "detail";
    private static final String ANSWER = "answer";
    private static final String WORKSHEET = "worksheet";

    @Column(name = DETAIL)
    public String detail;

    @Column(name = ANSWER)
    public int answer;

    @Column(name = WORKSHEET)
    public Worksheet worksheet;

    public static void createQuestions(Worksheet worksheet, List<QuestionDto> questions) {
        ActiveAndroid.beginTransaction();
        try {
            for (QuestionDto dto : questions) {
                Question question = new Question();
                question.detail = dto.getQuestion();
                question.answer = dto.getAnswer();
                question.worksheet = worksheet;
                question.save();
            }

            ActiveAndroid.setTransactionSuccessful();
        }
        finally {
            ActiveAndroid.endTransaction();
        }
    }
}
