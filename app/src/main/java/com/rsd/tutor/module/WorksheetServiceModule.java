package com.rsd.tutor.module;

import com.rsd.tutor.activity.WorksheetAssignedActivity;
import com.rsd.tutor.service.WorksheetService;
import com.rsd.tutor.service.WorksheetServiceStub;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Raukawa on 2/22/14.
 */

@Module (
        injects = WorksheetAssignedActivity.class
)
public class WorksheetServiceModule {

    @Provides
    @Singleton
    @Named(Service.WORKSHEET_STUB)
    WorksheetService provideWorksheetService() {
        return new WorksheetServiceStub();
    }
}
