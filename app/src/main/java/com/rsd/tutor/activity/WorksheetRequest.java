package com.rsd.tutor.activity;

import com.rsd.tutor.persistence.domain.Worksheet;

import java.util.List;

/**
 * Created by Raukawa on 2/22/14.
 */
public interface WorksheetRequest {
    void setWorksheets(List<Worksheet> worksheets);
}
