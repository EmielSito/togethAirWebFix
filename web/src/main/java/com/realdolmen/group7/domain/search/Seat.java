package com.realdolmen.group7.domain.search;


import javax.persistence.*;

/**
 * Created by ESOBG49 on 6/11/2017.
 */

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private ClassType classType;

    private String SeatNumber;

    public long getId() {
        return id;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public String getSeatNumber() {
        return SeatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        SeatNumber = seatNumber;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    private double basePrice;






}
