package com.rsd.tutor.service;

import com.rsd.tutor.activity.AuthenticationRequest;

/**
 * Created by wadereweti on 9/02/14.
 */
public interface AuthenticationService {
    public boolean authenticateCredentials(String userName, String password);
}
