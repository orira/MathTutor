package com.rsd.tutor.persistence.domain;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.rsd.tutor.dto.WorksheetDto;

import java.util.Date;
import java.util.List;

/**
 * Created by wadereweti on 10/02/14.
 */
@Table(name = "Worksheet")
public class Worksheet extends Model{

    @Column(name = "NumberOfQuestions")
    public int numberOfQuestions;

    @Column(name = "Status")
    public int status;

    @Column(name = "duration")
    public Date duration;

    public Worksheet() {
        super();
    }

    public Worksheet(WorksheetDto dto) {
        Worksheet worksheet = new Worksheet();
        worksheet.numberOfQuestions = dto.getNumberOfQuestions();
        worksheet.status = dto.getStatus().getValue();
        worksheet.duration = dto.getDuration();
    }

    public List<Question> questions() {
        return getMany(Question.class, "Worksheet");
    }
}
