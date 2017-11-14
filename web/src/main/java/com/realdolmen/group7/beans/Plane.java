package com.realdolmen.group7.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Plane {

    private String destinationLocation;

    private String departureLocation;

    private String airlineCompany;

    private double originalPrice;

    private double reducedPrice;

    private String departureDateTime;

    private String arrivalDateTime;

    private Map<String,Seat> availableSeats = new TreeMap<>();

    private int numberOfPassengers = 0;


    public Plane(String destinationLocation, String departureLocation, String airlineCompany, double originalPrice, double reducedPrice,
                 String departureDateTime, String arrivalDateTime, int numberOfPassengers) {
        this.destinationLocation = destinationLocation;
        this.departureLocation = departureLocation;
        this.airlineCompany = airlineCompany;
        this.originalPrice = originalPrice;
        this.reducedPrice = reducedPrice;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.numberOfPassengers = numberOfPassengers;

        availableSeats.put("1A",new Seat("1A","First Class"));
        availableSeats.put("1B", new Seat("1B","First Class"));
        availableSeats.put("2A",new Seat("2A","Business"));
        availableSeats.put("2B",new Seat("2B","Business"));
        availableSeats.put("3A", new Seat("3A","Economy"));
        availableSeats.put("3B", new Seat("3B","Economy"));
        availableSeats.put("4A",new Seat("4A","Economy"));
        availableSeats.put("4B",new Seat("4B","Economy"));
        availableSeats.put("5A", new Seat("5A","Economy"));
        availableSeats.put("5B",new Seat("5B","Economy"));
        availableSeats.put("6A",new Seat("6A","Economy"));
        availableSeats.put("6B",new Seat("6B","Economy"));
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(String airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(double reducedPrice) {
        this.reducedPrice = reducedPrice;
    }

    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(String arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public Map<String, Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Map<String, Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}
