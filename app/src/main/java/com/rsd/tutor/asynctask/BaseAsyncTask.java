package com.rsd.tutor.asynctask;

import android.os.AsyncTask;

import com.rsd.tutor.activity.AsyncTaskCallBack;

/**
 * Created by Raukawa on 2/23/14.
 */
public class BaseAsyncTask extends AsyncTask<Void, Integer, Void> {

    private AsyncTaskCallBack mAsyncTaskCallBack;

    public BaseAsyncTask(AsyncTaskCallBack asyncTaskCallBack) {
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
    protected Void doInBackground(Void... voids) {
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        mAsyncTaskCallBack.onProgressUpdate(values[0]);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        mAsyncTaskCallBack.onPostExecute();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();

        if (mAsyncTaskCallBack != null) {
            mAsyncTaskCallBack.onCancelled();
        }
    }
}
