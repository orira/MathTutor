package com.rsd.tutor.service;

import android.os.Handler;

import com.rsd.tutor.activity.AuthenticationRequest;

import javax.inject.Singleton;

/**
 * Created by wadereweti on 9/02/14.
 */
@Singleton
public class AuthenticationServiceStub implements AuthenticationService {

    @Override
    public void authenticateCredentials(final AuthenticationRequest authenticationRequest, String userName, String password) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                authenticationRequest.authenticationComplete(true);
            }
        }, 3000);

    }
}
