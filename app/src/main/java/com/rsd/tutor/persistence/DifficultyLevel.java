package com.rsd.tutor.persistence;

/**
 * Created by Raukawa on 2/19/14.
 */
public enum DifficultyLevel {
    ENTRY("Entry"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced");

    private final String displayName;

    private DifficultyLevel(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
