package com.rsd.tutor.activity;

/**
 * Created by Raukawa on 2/23/14.
 */
public interface AsyncTaskCallBack {
    void onPreExecute();
    void onProgressUpdate(int percent);
    void onCancelled();
    void onPostExecute();
}
