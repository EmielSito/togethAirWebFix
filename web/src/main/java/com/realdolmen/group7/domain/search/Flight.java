package com.realdolmen.group7.domain.search;



import com.realdolmen.group7.domain.booking.Booking;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ESOBG49 on 6/11/2017.
 */

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(nullable = false)
    private String flightNumber;

    @ManyToOne
    private Location departure;

    @ManyToOne
    private Location destination;

    @OneToMany
    private List<Plane> planes = new ArrayList<>();

    @ManyToOne
    private Airline airline;

    @ManyToMany(mappedBy = "flights")
    private List<Booking> bookings = new ArrayList<>();

    public Long getId() {
        return id;
    }


    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Location getDeparture() {
        return departure;
    }

    public void setDeparture(Location departure) {
        this.departure = departure;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}
