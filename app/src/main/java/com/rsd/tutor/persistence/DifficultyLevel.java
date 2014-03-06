package com.rsd.tutor.persistence;

/**
 * Created by Raukawa on 2/19/14.
 */
public enum DifficultyLevel {
    ENTRY(0),
    INTERMEDIATE(1),
    ADVANCED(2);

    private static final String ENTRY_LEVEL_DISPLAY_NAME = "Entry";
    private static final String INTERMEDIATE_LEVEL_DISPLAY_NAME = "Intermediate";
    private static final String ADVANCED_LEVEL_DISPLAY_NAME = "Advanced";

    private final int value;
    private final String displayName;

    private DifficultyLevel(final int value) {
        this.value = value;
        this.displayName = setDisplayName();
    }

    private String setDisplayName() {
        String displayName;

        switch (value) {
            case 0:
                displayName = ENTRY_LEVEL_DISPLAY_NAME;
                break;
            case 1:
                displayName = INTERMEDIATE_LEVEL_DISPLAY_NAME;
                break;
            case 2:
                displayName = ADVANCED_LEVEL_DISPLAY_NAME;
                break;
            default:
                displayName = ENTRY_LEVEL_DISPLAY_NAME;
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
