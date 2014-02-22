package com.rsd.tutor.service;

import com.rsd.tutor.activity.WorksheetRequest;
import com.rsd.tutor.persistence.WorksheetStatus;
import com.rsd.tutor.persistence.domain.Worksheet;

import java.util.List;

import javax.inject.Singleton;

/**
 * Created by Raukawa on 2/22/14.
 */

@Singleton
public class WorksheetServiceStub implements WorksheetService {

    @Override
    public List<Worksheet> getWorksheetsFromServer() {
        return null;
    }

    @Override
    public List<Worksheet> getWorksheetsFromDb(WorksheetRequest worksheetRequest, WorksheetStatus status) {
        return Worksheet.getAllByStatus(status);
    }
}
