package com.rsd.tutor.service;

import com.rsd.tutor.activity.WorksheetRequest;
import com.rsd.tutor.dto.QuestionDto;
import com.rsd.tutor.dto.WorksheetDto;
import com.rsd.tutor.persistence.DifficultyLevel;
import com.rsd.tutor.persistence.WorksheetStatus;
import com.rsd.tutor.persistence.domain.Worksheet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Singleton;

/**
 * Created by Raukawa on 2/22/14.
 */

@Singleton
public class WorksheetServiceStub implements WorksheetService {

    private static final String TAG = "WorksheetServiceStub";

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
        List<WorksheetDto> worksheetsToSave = findNewWorksheets(dtos);

        for (WorksheetDto dto : worksheetsToSave) {
            Worksheet.createWorksheet(dto);
        }

        List<Worksheet> worksheets = Worksheet.getAll();

        String foo = "foo";



        // TODO: Investigate if wrapped in a transaction is more performant
        /*for (WorksheetDto dto : dtos) {
            ActiveAndroid.beginTransaction();
            try {
                Worksheet.createWorksheet(dto);
                ActiveAndroid.setTransactionSuccessful();
            }
            finally {
                ActiveAndroid.endTransaction();
            }
        }*/
    }

    private List<WorksheetDto> findNewWorksheets(List<WorksheetDto> dtos) {

        List<Long> persistedIds = new ArrayList<Long>();
        for (Worksheet worksheet : Worksheet.getAllByStatus(WorksheetStatus.ASSIGNED)) {
            persistedIds.add(worksheet.serverId);
        }

        List<Long> newIds = new ArrayList<Long>();
        for (WorksheetDto dto : dtos) {
            newIds.add(dto.getId());
        }

        newIds.removeAll(persistedIds);

        List<WorksheetDto> dtosToSave = new ArrayList<WorksheetDto>();
        for (WorksheetDto dto : dtos) {
            for (Long id : newIds) {
                if (id == dto.getId()) {
                    dtosToSave.add(dto);
                }
            }
        }

        return dtosToSave;
    }

    private List<WorksheetDto> createStubWorksheets() {
        List<WorksheetDto> dtos = new ArrayList<WorksheetDto>();

        for (int i = 0; i < 3; i++) {
            WorksheetDto dto = new WorksheetDto();
            dto.setId(i);
            dto.setWorksheetId("WSY1E-C");
            dto.setTitle("Can you count the objects");
            dto.setQuestions(createQuestions(20));
            dto.setEstimatedDurationToComplete(returnTimeInMinutes(20));
            dto.setDifficultyLevel(DifficultyLevel.ENTRY);
            dto.setAssignedDate(new Date());
            dto.setStatus(WorksheetStatus.ASSIGNED);
            dto.setCompletedDate(new Date());
            dto.setAssessedDate(new Date());
            dto.setAssessor("test assessor");
            dtos.add(dto);
        }

        return dtos;
    }

    private Date returnTimeInMinutes(int minutes) {
        SimpleDateFormat timeFormatter = new SimpleDateFormat("mm");

        Date time = null;
        try {
            time = timeFormatter.parse(Integer.toString(minutes));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return time;
    }

    private List<QuestionDto> createQuestions(int numberOfQuestions) {
        List<QuestionDto> questions = new ArrayList<QuestionDto>();

        QuestionDto dto = new QuestionDto();
        for (int i = 0; i < numberOfQuestions; i++) {
            dto.setQuestion("how many tables are there");
            dto.setAnswer(5);
            questions.add(dto);
        }

        return questions;
    }
}
