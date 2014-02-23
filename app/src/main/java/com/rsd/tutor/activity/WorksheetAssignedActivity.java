package com.rsd.tutor.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.rsd.tutor.R;
import com.rsd.tutor.module.Service;
import com.rsd.tutor.module.WorksheetServiceModule;
import com.rsd.tutor.persistence.SharedPrefs;
import com.rsd.tutor.persistence.WorksheetStatus;
import com.rsd.tutor.persistence.domain.Worksheet;
import com.rsd.tutor.service.WorksheetService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.ObjectGraph;

/**
 * Created by Raukawa on 2/16/14.
 */
public class WorksheetAssignedActivity extends AbstractActivity implements WorksheetRequest {

    @Inject
    @Named(Service.WORKSHEET_STUB)
    WorksheetService mWorksheetService;

    private List<Worksheet> mWorksheets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_worksheet_assigned);

        initialiseInjection();
        getWorksheets();

        if (checkFirstTimeUser()) {
            displayDiagnosticTest();
        } else {

        }
    }

    @Override
    protected void asyncTaskComplete(boolean result) {

    }

    private void initialiseInjection() {
        ObjectGraph.create(new WorksheetServiceModule()).inject(this);
    }

    private void getWorksheets() {
        mWorksheetService.getWorksheetsFromDb(this, WorksheetStatus.ASSIGNED);
    }

    private boolean checkFirstTimeUser() {
        SharedPreferences sharedPreferences = getSharedPreferences(SharedPrefs.SETTINGS, Activity.MODE_PRIVATE);

        return sharedPreferences.getBoolean(SharedPrefs.FIRST_TIME_USER, false);
    }

    private void displayDiagnosticTest() {

    }

    @Override
    public void setWorksheets(List<Worksheet> worksheets) {
        mWorksheets = worksheets;
    }
}
