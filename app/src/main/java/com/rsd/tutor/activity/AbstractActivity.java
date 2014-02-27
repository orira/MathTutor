package com.rsd.tutor.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.rsd.tutor.fragment.headless.TaskFragment;

import butterknife.ButterKnife;

/**
 * Created by Raukawa on 2/19/14.
 */
public abstract class AbstractActivity extends FragmentActivity implements AsyncTaskCallBack {

    protected static final boolean debug = false;
    private static final String TASK_FRAGMENT_TAG = "task";

    private TaskFragment mTaskFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void initialiseViewInjection() {
        ButterKnife.inject(this);
    }

    protected void initialiseTaskFragment(TaskFragment taskFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        mTaskFragment = (TaskFragment) fragmentManager.findFragmentByTag(TASK_FRAGMENT_TAG);

        if (mTaskFragment == null) {
            mTaskFragment = taskFragment;
            fragmentManager.beginTransaction().add(mTaskFragment, TASK_FRAGMENT_TAG).commit();
            mTaskFragment.executeAsyncTask();
        }
    }

    @Override
    public void onPreExecute() {

    }

    @Override
    public void onProgressUpdate(int percent) {

    }

    @Override
    public void onCancelled() {

    }

    @Override
    public void onPostExecute(boolean result) {
        asyncTaskComplete(result);
    }

    // Leave implementation to subclass
    protected abstract void asyncTaskComplete(boolean result);
}
