package com.realdolmen.group7.domain.users;

import com.realdolmen.group7.domain.search.Airline;

import javax.persistence.*;

/**
 * Created by ESOBG49 on 6/11/2017.
 */
@Entity
public class Partner extends Person{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Airline airline;
}
