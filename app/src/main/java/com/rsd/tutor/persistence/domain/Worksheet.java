package com.rsd.tutor.persistence.domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.rsd.tutor.dto.WorksheetDto;
import com.rsd.tutor.persistence.DifficultyLevel;
import com.rsd.tutor.persistence.WorksheetStatus;

import java.util.Date;
import java.util.List;

/**
 * Created by wadereweti on 10/02/14.
 */
@Table(name = "Worksheet")
public class Worksheet extends Model implements Parcelable{
    private static final String TAG = "Worksheet";

    private static final String SERVER_ID = "serverId";
    private static final String WORKSHEET_ID = "worksheetId";
    private static final String TITLE = "title";
    private static final String ESTIMATED_DURATION_TO_COMPLETE = "estimatedDurationToComplete";
    private static final String DIFFICULTY_LEVEL = "difficultyLevel";
    private static final String NAME = "Worksheet";
    private static final String STATUS = "status";
    private static final String START_DATE = "startDat";
    private static final String DURATION = "duration";
    private static final String ASSIGNED_DATE = "assignedDate";
    private static final String COMPLETED_DATE = "completedDate";
    private static final String ASSESSED_DATE = "assessedDate";
    private static final String ASSESSOR = "assessor";

    private static final String IS_EQUAL_TO = " = ?";

    @Column(name = SERVER_ID)
    public long serverId;

    @Column(name = WORKSHEET_ID)
    public String worksheetId;

    @Column(name = TITLE)
    public String title;

    @Column(name = ESTIMATED_DURATION_TO_COMPLETE)
    public Date estimatedDurationToComplete;

    @Column(name = DIFFICULTY_LEVEL)
    public DifficultyLevel difficultyLevel;

    @Column(name = ASSIGNED_DATE)
    public Date assignedDate;

    @Column(name = STATUS)
    public WorksheetStatus status;

    @Column(name = START_DATE)
    public Date startDate;

    @Column(name = COMPLETED_DATE)
    public Date completedDate;

    @Column(name = DURATION)
    public Date duration;

    @Column(name = ASSESSED_DATE)
    public Date assessedDate;

    @Column(name = ASSESSOR)
    public String assessor;

    public Worksheet() {}

    public Worksheet(Parcel parcel) {
        serverId = parcel.readLong();
        worksheetId = parcel.readString();
        title = parcel.readString();
        estimatedDurationToComplete = new Date(parcel.readLong());
        assignedDate = new Date(parcel.readLong());
        completedDate = new Date(parcel.readLong());
        duration = new Date(parcel.readLong());
        assessedDate = new Date(parcel.readLong());
        assessor = parcel.readString();
    }

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
        worksheet.worksheetId = dto.getWorksheetId();
        worksheet.title = dto.getTitle();
        worksheet.estimatedDurationToComplete = dto.getEstimatedDurationToComplete();
        worksheet.difficultyLevel = dto.getDifficultyLevel();
        worksheet.assignedDate = dto.getAssignedDate();
        worksheet.status = dto.getStatus();
        worksheet.completedDate = dto.getCompletedDate();
        worksheet.duration = dto.getDuration();
        worksheet.assessedDate = dto.getAssessedDate();
        worksheet.assessor = dto.getAssessor();

        worksheet.save();

        Question.createQuestions(worksheet, dto.getQuestions());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(serverId);
        dest.writeString(worksheetId);
        dest.writeString(title);
        dest.writeLong(estimatedDurationToComplete.getTime());
        dest.writeLong(assignedDate.getTime());
        dest.writeLong(completedDate.getTime());
        dest.writeLong(duration.getTime());
        dest.writeLong(assessedDate.getTime());
        dest.writeString(assessor);
    }

    public static final Parcelable.Creator<Worksheet> CREATOR = new Parcelable.Creator<Worksheet>() {
        public Worksheet createFromParcel(Parcel parcel) {
            return new Worksheet(parcel);
        }

        public Worksheet[] newArray(int size) {
            return new Worksheet[size];
        }
    };
}
