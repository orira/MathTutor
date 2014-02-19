package com.rsd.tutor.dto;

import java.util.Date;

/**
 * Created by Raukawa on 2/19/14.
 */
public class ChildDto {
    private String firstName;
    private String familyName;
    private Date dateOfBirth;
    private int schoolYear;
    private int mathAbility;
    private int gamePoints;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    public int getMathAbility() {
        return mathAbility;
    }

    public void setMathAbility(int mathAbility) {
        this.mathAbility = mathAbility;
    }

    public int getGamePoints() {
        return gamePoints;
    }

    public void setGamePoints(int gamePoints) {
        this.gamePoints = gamePoints;
    }
}
