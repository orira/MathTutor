package com.rsd.tutor.module;

import com.rsd.tutor.activity.LoginActivity;
import com.rsd.tutor.asynctask.LoginAsyncTask;
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
        injects = {LoginActivity.class, LoginAsyncTask.class}
)
public class AuthenticationServiceModule {

    /*@Provides @Singleton @Named(Service.LOGIN_SERVICE_IMPL) AuthenticationService provideLoginServiceImpl() {
        return new AuthenticationServiceImpl();
    }*/

    @Provides
    @Singleton
    @Named(Service.LOGIN_SERVICE_STUB)
    AuthenticationService provideLoginServiceStub() {
        return new AuthenticationServiceStub();
    }
}
