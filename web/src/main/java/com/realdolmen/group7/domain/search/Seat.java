package com.realdolmen.group7.domain.search;


import javax.persistence.*;

/**
 * Created by ESOBG49 on 6/11/2017.
 */

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ClassType classType;

    private String SeatNumber;

    private boolean isAvailable;

    @ManyToOne
    private Plane plane;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
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
