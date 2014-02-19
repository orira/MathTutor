package com.rsd.tutor.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.rsd.tutor.R;

/**
 * Created by Raukawa on 2/19/14.
 */
public class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialiseActionBar();
    }

    private void initialiseActionBar() {
        getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.base_accent));
    }
}
