package com.rsd.tutor.service;

import javax.inject.Singleton;

/**
 * Created by wadereweti on 9/02/14.
 */
@Singleton
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public boolean authenticateCredentials(String userName, String password) {
        return true;
    }
}
