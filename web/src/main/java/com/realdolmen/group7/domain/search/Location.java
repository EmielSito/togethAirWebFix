package com.realdolmen.group7.domain.search;


import javax.persistence.*;
import java.util.List;

/**
 * Created by ESOBG49 on 6/11/2017.
 */

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private long locationId;

    private String airportName;

    private String airportCountry;

    private String airportCode;


    @Enumerated(EnumType.STRING)
    private Region region;

    @OneToMany
    private List<Flight> flights;




}
