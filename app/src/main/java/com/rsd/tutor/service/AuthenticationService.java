package com.rsd.tutor.service;

/**
 * Created by wadereweti on 9/02/14.
 */
public interface AuthenticationService {
    public boolean authenticateCredentials(String userName, String password);
}
