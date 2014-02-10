package com.rsd.tutor.service;

import android.os.Handler;

import javax.inject.Singleton;

/**
 * Created by wadereweti on 9/02/14.
 */
@Singleton
public class LoginServiceStub implements LoginService {

    @Override
    public boolean login(String userName, String password) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
