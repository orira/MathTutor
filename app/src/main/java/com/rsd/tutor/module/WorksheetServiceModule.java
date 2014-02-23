package com.rsd.tutor.module;

import com.rsd.tutor.activity.WorksheetAssignedActivity;
import com.rsd.tutor.asynctask.WorksheetAsyncTask;
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
        injects = {WorksheetAssignedActivity.class, WorksheetAsyncTask.class},
        library = true
)
public class WorksheetServiceModule {

    @Provides
    @Singleton
    @Named(Service.WORKSHEET_STUB)
    WorksheetService provideWorksheetServiceStub() {
        return new WorksheetServiceStub();
    }

    @Provides
    @Singleton
    @Named(Service.WORKSHEET_IMPL)
    WorksheetService provideWorksheetServiceImpl() {
        return new WorksheetServiceStub();
    }
}
