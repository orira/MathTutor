package com.rsd.tutor.service;

import com.rsd.tutor.activity.WorksheetRequest;
import com.rsd.tutor.dto.QuestionDto;
import com.rsd.tutor.dto.WorksheetDto;
import com.rsd.tutor.persistence.WorksheetStatus;
import com.rsd.tutor.persistence.domain.Worksheet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Singleton;

/**
 * Created by Raukawa on 2/22/14.
 */

@Singleton
public class WorksheetServiceStub implements WorksheetService {

    @Override
    public void getWorksheetsFromServer() {
        List<WorksheetDto> dtos = createStubWorksheets();
        convertDtosToDomainObjects(dtos);
    }

    @Override
    public List<Worksheet> getWorksheetsFromDb(WorksheetRequest worksheetRequest, WorksheetStatus status) {
        return Worksheet.getAllByStatus(status);
    }

    @Override
    public void convertDtosToDomainObjects(List<WorksheetDto> dtos) {
        for (WorksheetDto dto : dtos) {
            Worksheet.createWorksheet(dto);
        }
    }

    private List<WorksheetDto> createStubWorksheets() {
        List<WorksheetDto> dtos = new ArrayList<WorksheetDto>();

        WorksheetDto dto = new WorksheetDto();
        dto.setAssessedDate(new Date());
        dto.setAssessor("test assessor");
        dto.setAssignedDate(new Date());
        dto.setCompletedDate(new Date());
        dto.setDuration(null);
        dto.setNumberOfQuestions(20);
        dto.setQuestions(createQuestions(20));
        dto.setStatus(WorksheetStatus.ASSIGNED);

        dtos.add(dto);

        return dtos;
    }

    private List<QuestionDto> createQuestions(int numberOfQuestions) {
        List<QuestionDto> questions = new ArrayList<QuestionDto>();

        QuestionDto dto = new QuestionDto();
        for (int i = 0; i < numberOfQuestions; i++) {
            dto.setQuestion("how many boonjargs are there");
            dto.setAnswer(5);
            questions.add(dto);
        }

        return questions;
    }
}
