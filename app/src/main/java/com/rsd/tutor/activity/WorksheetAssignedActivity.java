package com.rsd.tutor.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.rsd.tutor.persistence.SharedPrefs;

/**
 * Created by Raukawa on 2/16/14.
 */
public class WorksheetAssignedActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        checkFirstTimeUser();
    }

    private void checkFirstTimeUser() {
        SharedPreferences sharedPreferences = getSharedPreferences(SharedPrefs.SETTINGS, Activity.MODE_PRIVATE);
        boolean firstTimeUser = sharedPreferences.getBoolean(SharedPrefs.FIRST_TIME_USER, false);

        if (firstTimeUser) {
            displayDiagnosticTest();
        }
    }

    private void displayDiagnosticTest() {

    }
}
