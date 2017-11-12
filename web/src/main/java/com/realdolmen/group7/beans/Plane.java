package com.realdolmen.group7.beans;

public class Plane {

    private String destinationLocation;

    private String departureLocation;

    private String airlineCompany;

    private double originalPrice;

    private double reducedPrice;

    private String departureDateTime;

    private String arrivalDateTime;


    public Plane(String destinationLocation, String departureLocation, String airlineCompany, double originalPrice, double reducedPrice, String departureDateTime, String arrivalDateTime) {
        this.destinationLocation = destinationLocation;
        this.departureLocation = departureLocation;
        this.airlineCompany = airlineCompany;
        this.originalPrice = originalPrice;
        this.reducedPrice = reducedPrice;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
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
}
