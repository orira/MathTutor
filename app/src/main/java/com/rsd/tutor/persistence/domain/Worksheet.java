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
    private static final String TAG = "Worksheet";

    private static final String SERVER_ID = "serverId";
    private static final String NAME = "Worksheet";
    private static final String NUMBER_OF_QUESTIONS = "NumberOfQuestions";
    private static final String STATUS = "status";
    private static final String DURATION = "duration";
    private static final String ASSIGNED_DATE = "assignedDate";
    private static final String COMPLETED_DATE = "completedDate";
    private static final String ASSESSED_DATE = "assessedDate";
    private static final String ASSESSOR = "assessor";

    private static final String IS_EQUAL_TO = " = ?";

    @Column(name = SERVER_ID)
    public long serverId;

    @Column(name = NUMBER_OF_QUESTIONS)
    public int numberOfQuestions;

    @Column(name = STATUS)
    public WorksheetStatus status;

    @Column(name = DURATION)
    public Date duration;

    @Column(name = ASSIGNED_DATE)
    private Date assignedDate;

    @Column(name = COMPLETED_DATE)
    private Date completedDate;

    @Column(name = ASSESSED_DATE)
    private Date assessedDate;

    @Column(name = ASSESSOR)
    private String assessor;

    public List<Question> questions() {
        return getMany(Question.class, NAME);
    }

    public static List<Worksheet> getAll() {
        return new Select()
                .from(Worksheet.class)
                .execute();
    }

    public static List<Worksheet> getAllByStatus(WorksheetStatus status) {
        return new Select()
                .from(Worksheet.class)
                .where(STATUS + IS_EQUAL_TO, status)
                .execute();
    }

    public static void createWorksheet(WorksheetDto dto) {
        Worksheet worksheet = new Worksheet();
        worksheet.serverId = dto.getId();
        worksheet.numberOfQuestions = dto.getNumberOfQuestions();
        worksheet.status = dto.getStatus();
        worksheet.duration = dto.getDuration();
        worksheet.assignedDate = dto.getAssignedDate();
        worksheet.completedDate = dto.getCompletedDate();
        worksheet.assessedDate = dto.getAssessedDate();
        worksheet.assessor = dto.getAssessor();

        worksheet.save();

        Question.createQuestions(worksheet, dto.getQuestions());
    }
}
