package com.realdolmen.group7.domain.search;


import javax.persistence.*;

/**
 * Created by ESOBG49 on 6/11/2017.
 */

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private ClassType classType;

    private String SeatNumber;

    private double basePrice;






}
