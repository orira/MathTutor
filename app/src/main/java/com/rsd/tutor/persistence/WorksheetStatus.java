package com.rsd.tutor.persistence;

/**
 * Created by Raukawa on 2/19/14.
 */
public enum WorksheetStatus {
    ASSIGNED(0),
    COMPLETED(1),
    ASSESSED(2);

    private final int value;

    private WorksheetStatus(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
