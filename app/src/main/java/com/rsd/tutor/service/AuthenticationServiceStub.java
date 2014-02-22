package com.rsd.tutor.service;

import javax.inject.Singleton;

/**
 * Created by wadereweti on 9/02/14.
 */
@Singleton
public class AuthenticationServiceStub implements AuthenticationService {

    @Override
    public boolean authenticateCredentials(String userName, String password) {

        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        return true;
    }
}
