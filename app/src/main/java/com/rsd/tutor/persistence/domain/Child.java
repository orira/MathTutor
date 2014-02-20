package com.rsd.tutor.persistence.domain;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.rsd.tutor.dto.ChildDto;

import java.util.Date;

/**
 * Created by Raukawa on 2/19/14.
 */

@Table(name = "Child")
public class Child extends Model {
    @Column(name = "FirstName")
    public String firstName;

    @Column(name = "FamilyName")
    public String familyName;

    @Column(name = "DateOfBirth")
    public Date dateOfBirth;

    @Column(name = "SchoolYear")
    public int schoolYear;

    @Column(name = "MathAbility")
    public int mathAbility;

    @Column(name = "GamePoints")
    public int gamePoints;

    public Child() {
        super();
    }

    public Child(ChildDto dto) {
        super();

        Child child = new Child();
        child.firstName = dto.getFirstName();
        child.familyName = dto.getFamilyName();
        child.dateOfBirth = dto.getDateOfBirth();
        child.schoolYear = dto.getSchoolYear();
        child.mathAbility = dto.getMathAbility();
        child.gamePoints = dto.getGamePoints();

        child.save();
    }
}
