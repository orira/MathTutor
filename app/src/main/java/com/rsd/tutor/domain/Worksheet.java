package com.rsd.tutor.domain;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;
import java.util.List;

/**
 * Created by wadereweti on 10/02/14.
 */
@Table(name = "Worksheet")
public class Worksheet extends Model{

    @Column(name = "assigned")
    public Date assigned;

    @Column(name = "completed")
    public Date completed;

    @Column(name = "duration")
    public Date duration;

    public List<Question> questions() {
        return getMany(Question.class, "Worksheet");
    }
}
