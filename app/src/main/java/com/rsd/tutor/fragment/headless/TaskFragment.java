package com.rsd.tutor.fragment.headless;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.rsd.tutor.activity.AsyncTaskCallBack;

/**
 * Created by Raukawa on 2/23/14.
 */
public class TaskFragment extends Fragment {

    private AsyncTaskCallBack mCallBack;
    private AsyncTask mTask;

    public TaskFragment(AsyncTask asyncTask) {
        mTask = asyncTask;
    }

    /**
     * This method will only be called once when the
     * retained Fragment is first created
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallBack = (AsyncTaskCallBack) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retain fragment across configuration changes;
        setRetainInstance(true);
    }

    /**
     * Set the callback to null so we don't accidentally leak the
     * Activity instance.
     */
    @Override
    public void onDetach() {
        super.onDetach();
        mCallBack = null;
    }

    public void executeAsyncTask() {
        mTask.execute();
    }
}
