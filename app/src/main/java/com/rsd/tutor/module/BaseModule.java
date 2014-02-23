package com.rsd.tutor.module;

import dagger.Module;

/**
 * Created by Raukawa on 2/24/14.
 */
@Module(
        includes = {
                AuthenticationServiceModule.class,
                WorksheetServiceModule.class
        }
)
public class BaseModule {
}
