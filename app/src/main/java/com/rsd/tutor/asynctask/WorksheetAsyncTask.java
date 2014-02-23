package com.rsd.tutor.asynctask;

import com.rsd.tutor.activity.AsyncTaskCallBack;
import com.rsd.tutor.module.Service;
import com.rsd.tutor.module.WorksheetServiceModule;
import com.rsd.tutor.service.WorksheetService;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.ObjectGraph;

/**
 * Created by Raukawa on 2/23/14.
 */
public class WorksheetAsyncTask extends AbstractAsyncTask<Object, Void, Boolean> {

    @Inject
    @Named(Service.WORKSHEET_STUB)
    WorksheetService mWorksheetService;

    public WorksheetAsyncTask(AsyncTaskCallBack callBack) {
        super(callBack);

        ObjectGraph.create(new WorksheetServiceModule()).inject(this);
    }

    @Override
    protected Boolean doInBackground(Object... params) {
        mWorksheetService.getWorksheetsFromServer();

        return true;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        if (mAsyncTaskCallBack != null) {
            mAsyncTaskCallBack.onPostExecute(result);
        }
    }
}
