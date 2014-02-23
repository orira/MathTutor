package com.rsd.tutor.service;

import com.rsd.tutor.activity.WorksheetRequest;
import com.rsd.tutor.dto.WorksheetDto;
import com.rsd.tutor.persistence.WorksheetStatus;
import com.rsd.tutor.persistence.domain.Worksheet;

import java.util.List;

/**
 * Created by Raukawa on 2/22/14.
 */
public interface WorksheetService {
    void getWorksheetsFromServer();
    List<Worksheet> getWorksheetsFromDb(WorksheetRequest worksheetRequest, WorksheetStatus status);
    void convertDtosToDomainObjects(List<WorksheetDto> dtos);
}
