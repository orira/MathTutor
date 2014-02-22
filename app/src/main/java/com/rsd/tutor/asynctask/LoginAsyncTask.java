package com.rsd.tutor.asynctask;

import android.os.AsyncTask;

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
public class LoginAsyncTask extends AsyncTask<Object, Void, Boolean> {

    @Inject
    @Named(Service.LOGIN_SERVICE_STUB)
    AuthenticationService mAuthenticationService;

    private AuthenticationRequest mAuthenticationRequest;
    private String mUserName;
    private String mPassword;

    public LoginAsyncTask(AuthenticationRequest authenticationRequest, String userName, String password) {
        mAuthenticationRequest = authenticationRequest;
        mUserName = userName;
        mPassword = password;

        ObjectGraph.create(new AuthenticationServiceModule()).inject(this);
    }

    @Override
    protected Boolean doInBackground(Object... params) {
        return mAuthenticationService.authenticateCredentials(mUserName, mPassword);
    }

    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);

        mAuthenticationRequest.authenticationComplete(result);
    }
}
