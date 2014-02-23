package com.rsd.tutor.module;

import com.rsd.tutor.service.AuthenticationServiceStub;
import com.rsd.tutor.service.AuthenticationService;
import com.rsd.tutor.service.AuthenticationServiceImpl;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wadereweti on 9/02/14.
 */
/*@Module(
        injects = AuthenticationServiceImpl.class
)*/
public class DaoModule {

    /*@Provides
    @Singleton
    @Named(Service.LOGIN_IMPL)
    AuthenticationService provideLoginServiceImpl() {
        return new AuthenticationServiceImpl();
    }

    @Provides
    @Singleton
    @Named(Service.LOGIN_STUB)
    AuthenticationService provideLoginServiceStub() {
        return new AuthenticationServiceStub();
    }*/
}
