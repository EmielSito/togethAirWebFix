package com.realdolmen.group7.domain.search;

/**
 * Created by ESOBG49 on 6/11/2017.
 */

public enum  Region {
    EASTERNAFRICA("Eastern Africa"),
    MIDDLEAFRICA("Middle Africa"),
    NORTHERNAFRICA("Northern Africa"),
    SOUTHERNAFRICA("Southern Africa"),
    WESTERNAFRICA("Western Africa"),
    CENTRALAMERICA("Central America"),
    NORTHERNAMERICA("Northern America"),
    SOUTHAMERICA("South America"),
    CARIBBEAN("Caribbean"),
    CENTRALASIA("Central Asia"),
    EASTERNASIA("Eastern Asia"),
    SOUTHERNASIA("Southern Asia"),
    SOUTHEASTERNASIA("South-Eastern Asia"),
    WESTERNASIA("Western Asia"),
    EASTERNEUROPE("Eastern Europe"),
    NORTHERNEUROPE("Northern Europe"),
    SOUTHERNEUROPE("Southern Europe"),
    OCEANIA("Oceania");


    private final String classType;

    private Region(final String classType) {
        this.classType = classType;
    }

    @Override
    public String toString() {
        return classType;
    }

}
