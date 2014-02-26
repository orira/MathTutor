package com.rsd.tutor.module;

import android.content.Context;

import com.rsd.tutor.KaiakoApplication;
import com.rsd.tutor.asynctask.LoginAsyncTask;
import com.rsd.tutor.service.AuthenticationServiceImpl;
import com.rsd.tutor.service.AuthenticationServiceStub;
import com.rsd.tutor.service.AuthenticationService;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wadereweti on 9/02/14.
 */
@Module(
    injects = LoginAsyncTask.class,
    library = true
)
public class AuthenticationServiceModule {

    @Singleton
    @Provides
    @Named(Service.LOGIN_IMPL) AuthenticationService provideLoginServiceImpl() {
        return new AuthenticationServiceImpl();
    }

    @Singleton
    @Provides
    @Named(Service.LOGIN_STUB)
    AuthenticationService provideLoginServiceStub() {
        return new AuthenticationServiceStub();
    }
}
