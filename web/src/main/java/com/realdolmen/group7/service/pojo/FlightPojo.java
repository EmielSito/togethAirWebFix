package com.realdolmen.group7.service.pojo;


import com.realdolmen.group7.domain.search.Airline;
import com.realdolmen.group7.domain.search.Location;
import com.realdolmen.group7.domain.search.Plane;

/**
 * Created by ESOBG49 on 8/11/2017.
 */
public class FlightPojo {

    private String flightNumber;

    private Location departure;

    private Location destination;

    private Plane plane;

    private Airline airline;

    private long planeId;


    private double price;

    private int numberOfTickets;

    private double percentage;


    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
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


    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        setPlaneId(plane.getId());
        this.plane = plane;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public long getPlaneId() {
        return planeId;
    }

    public void setPlaneId(long planeId) {
        this.planeId = planeId;
    }
}
