package com.rsd.tutor.module;

import com.rsd.tutor.activity.LoginActivity;
import com.rsd.tutor.service.LoginService;
import com.rsd.tutor.service.LoginServiceStub;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wadereweti on 9/02/14.
 */
@Module(
        injects = LoginActivity.class
)
public class ServiceModule {

    /*@Provides @Singleton @Named(Service.LOGIN_SERVICE_IMPL) LoginService provideLoginServiceImpl() {
        return new LoginServiceImpl();
    }*/

    @Provides @Singleton @Named(Service.LOGIN_SERVICE_STUB) LoginService provideLoginServiceStub() {
        return new LoginServiceStub();
    }
}
