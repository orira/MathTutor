package com.rsd.tutor.asynctask;

import android.os.AsyncTask;

import com.rsd.tutor.activity.AsyncTaskCallBack;

import dagger.Provides;

/**
 * Created by Raukawa on 2/23/14.
 */
public abstract class AbstractAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {

    protected AsyncTaskCallBack mAsyncTaskCallBack;

    public AbstractAsyncTask(){}

    public AbstractAsyncTask(AsyncTaskCallBack asyncTaskCallBack) {
        mAsyncTaskCallBack = asyncTaskCallBack;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        if (mAsyncTaskCallBack != null) {
            mAsyncTaskCallBack.onPreExecute();
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();

        if (mAsyncTaskCallBack != null) {
            mAsyncTaskCallBack.onCancelled();
        }
    }
}
