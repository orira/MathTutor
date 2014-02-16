package com.rsd.tutor.domain;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by wadereweti on 10/02/14.
 */
@Table(name = "Question")
public class Question extends Model{
    @Column(name = "Question")
    public String question;

    @Column(name = "Answer")
    public int answer;

    @Column(name = "Worksheet")
    public Worksheet worksheet;
}
