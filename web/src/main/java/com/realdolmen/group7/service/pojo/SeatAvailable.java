package com.realdolmen.group7.service.pojo;

import com.realdolmen.group7.domain.search.ClassType;

import java.io.Serializable;
import java.util.Date;

public class SeatAvailable implements Serializable {
    private String planeNumber;
    private ClassType type;
    private int numberOfSeat;

    public String getPlaneNumber() {
        return planeNumber;
    }

    public void setPlaneNumber(String planeNumber) {
        this.planeNumber = planeNumber;
    }

    public ClassType getType() {
        return type;
    }

    public void setType(ClassType type) {
        this.type = type;
    }


    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }


}
