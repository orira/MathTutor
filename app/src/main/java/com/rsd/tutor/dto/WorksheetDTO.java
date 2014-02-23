package com.rsd.tutor.dto;

import com.rsd.tutor.persistence.WorksheetStatus;
import com.rsd.tutor.persistence.domain.Worksheet;

import java.util.Date;
import java.util.List;

/**
 * Created by wadereweti on 11/02/14.
 */
public class WorksheetDto {
    private long id;
    private int numberOfQuestions;
    private WorksheetStatus status;
    private Date duration;
    private Date assignedDate;
    private Date completedDate;
    private Date assessedDate;
    private String assessor;
    private List<QuestionDto> questions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public WorksheetStatus getStatus() {
        return status;
    }

    public void setStatus(WorksheetStatus status) {
        this.status = status;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public Date getAssessedDate() {
        return assessedDate;
    }

    public void setAssessedDate(Date assessedDate) {
        this.assessedDate = assessedDate;
    }

    public String getAssessor() {
        return assessor;
    }

    public void setAssessor(String assessor) {
        this.assessor = assessor;
    }

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }
}
