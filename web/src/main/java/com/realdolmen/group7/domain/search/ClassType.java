package com.realdolmen.group7.domain.search;

/**
 * Created by ESOBG49 on 6/11/2017.
 */
public enum ClassType {
BUSINESS("Business class"),
ECONOMY("Economy class");

    private final String classType;

    private ClassType(final String classType) {
        this.classType = classType;
    }

    @Override
    public String toString() {
        return classType;
    }

}
