package com.rsd.tutor.persistence;

/**
 * Created by Raukawa on 2/19/14.
 */
public enum WorksheetStatus {
    ASSIGNED(0),
    COMPLETED(1),
    ASSESSED(2);

    private static final String ASSIGNED_DISPLAY_NAME = "assigned";
    private static final String COMPLETED_DISPLAY_NAME = "completed";
    private static final String ASSESSED_DISPLAY_NAME = "assessed";

    private final int value;
    private final String displayName;

    private WorksheetStatus(final int value) {
        this.value = value;
        this.displayName = setDisplayName();
    }

    private String setDisplayName() {
        String displayName;

        switch (value) {
            case 0:
                displayName = ASSIGNED_DISPLAY_NAME;
                break;
            case 1:
                displayName = COMPLETED_DISPLAY_NAME;
                break;
            case 2:
                displayName = ASSESSED_DISPLAY_NAME;
                break;
            default:
                displayName = ASSIGNED_DISPLAY_NAME;
        }

        return displayName;
    }

    public int getValue() {
        return value;
    }

    public String getDisplayName() {
        return displayName;
    }
}
