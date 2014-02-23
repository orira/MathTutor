package com.rsd.tutor.persistence.domain;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.rsd.tutor.dto.WorksheetDto;
import com.rsd.tutor.persistence.WorksheetStatus;

import java.util.Date;
import java.util.List;

/**
 * Created by wadereweti on 10/02/14.
 */
@Table(name = "Worksheet")
public class Worksheet extends Model{
    private static final String NAME = "Worksheet";
    private static final String NUMBER_OF_QUESTIONS = "NumberOfQuestions";
    private static final String STATUS = "status";
    private static final String DURATION = "duration";

    private static final String IS_EQUAL_TO = " = ?";

    @Column(name = NUMBER_OF_QUESTIONS)
    public int numberOfQuestions;

    @Column(name = STATUS)
    public WorksheetStatus status;

    @Column(name = DURATION)
    public Date duration;

    public Worksheet() {
        super();
    }

    public Worksheet(WorksheetDto dto) {
        Worksheet worksheet = new Worksheet();
        worksheet.numberOfQuestions = dto.getNumberOfQuestions();
        worksheet.status = dto.getStatus();
        worksheet.duration = dto.getDuration();
    }

    public List<Question> questions() {
        return getMany(Question.class, NAME);
    }

    public static List<Worksheet> getAllByStatus(WorksheetStatus status) {
        return new Select()
                .from(Worksheet.class)
                .where(STATUS + IS_EQUAL_TO, status.getDisplayName())
                .execute();
    }

    public static void createWorksheet(WorksheetDto dto) {
        Worksheet worksheet = new Worksheet();
        //BeanUtils.copy


    }
}
