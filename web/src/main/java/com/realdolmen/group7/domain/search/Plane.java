package com.realdolmen.group7.domain.search;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by ESOBG49 on 6/11/2017.
 */
@Entity
public class Plane {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String planeNumber;


    @Temporal(value = TemporalType.TIMESTAMP)
    private Date departureTime;

    private boolean volumeDiscountAvailable;


    private Date durationInMinutes;



    @OneToMany
    private List<Seat> seats;






}
