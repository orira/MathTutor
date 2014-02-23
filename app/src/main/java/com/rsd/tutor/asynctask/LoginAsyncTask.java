package com.rsd.tutor.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import com.rsd.tutor.activity.AsyncTaskCallBack;
import com.rsd.tutor.activity.AuthenticationRequest;
import com.rsd.tutor.module.AuthenticationServiceModule;
import com.rsd.tutor.module.Service;
import com.rsd.tutor.service.AuthenticationService;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.ObjectGraph;

/**
 * Created by Raukawa on 2/23/14.
 */
public class LoginAsyncTask extends BaseAsyncTask<Object, Void, Boolean> {

    private static final String TAG = "LoginAsyncTask";

    @Inject
    @Named(Service.LOGIN_STUB)
    AuthenticationService mAuthenticationService;

    private String mUserName;
    private String mPassword;

    public LoginAsyncTask(AsyncTaskCallBack callBack, String userName, String password) {
        super(callBack);
        mUserName = userName;
        mPassword = password;

        ObjectGraph.create(new AuthenticationServiceModule()).inject(this);
    }

    @Override
    protected Boolean doInBackground(Object... voids) {
        Log.e(TAG, "starting call");

        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return mAuthenticationService.authenticateCredentials(mUserName, mPassword);
    }

    @Override
    protected void onPostExecute(Boolean result) {
        if (mAsyncTaskCallBack != null) {
            mAsyncTaskCallBack.onPostExecute(result);
        }
    }
}
