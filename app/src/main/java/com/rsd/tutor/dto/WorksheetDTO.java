package com.rsd.tutor.dto;

import com.rsd.tutor.persistence.DifficultyLevel;
import com.rsd.tutor.persistence.WorksheetStatus;

import java.util.Date;
import java.util.List;

/**
 * Created by wadereweti on 11/02/14.
 */
public class WorksheetDto {
    private long id;
    private String worksheetId;
    private String title;
    private List<QuestionDto> questions;
    private Date estimatedDurationToComplete;
    private DifficultyLevel difficultyLevel;
    private Date assignedDate;
    private WorksheetStatus status;
    private Date completedDate;
    private Date duration;
    private Date assessedDate;
    private String assessor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWorksheetId() {
        return worksheetId;
    }

    public void setWorksheetId(String worksheetId) {
        this.worksheetId = worksheetId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }

    public Date getEstimatedDurationToComplete() {
        return estimatedDurationToComplete;
    }

    public void setEstimatedDurationToComplete(Date estimatedDurationToComplete) {
        this.estimatedDurationToComplete = estimatedDurationToComplete;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public WorksheetStatus getStatus() {
        return status;
    }

    public void setStatus(WorksheetStatus status) {
        this.status = status;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
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
}
