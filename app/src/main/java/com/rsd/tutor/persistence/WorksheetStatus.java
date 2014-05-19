package com.rsd.tutor.persistence;

/**
 * Created by Raukawa on 2/19/14.
 */
public enum WorksheetStatus {
    ASSIGNED("Assigned"),
    COMPLETED("Completed"),
    ASSESSED("Assessed");

    private final String displayName;

    private WorksheetStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
