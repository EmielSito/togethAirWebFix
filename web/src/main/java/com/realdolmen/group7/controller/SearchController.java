package com.realdolmen.group7.controller;


import com.realdolmen.group7.domain.search.*;
import com.realdolmen.group7.service.SearchServiceImpl;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class SearchController {

    @Inject
    private SearchServiceImpl searchService;



    public List<Seat> getAvailableSeat(String planeNumber, String departure, String destination, Date departureDate, ClassType type) {
        return searchService.getAvailableSeat(planeNumber, departure, destination, departureDate, type);
    }
    public List<Plane> getByDepartureDate(Date departureDate, String departure, String destination) {
        return searchService.getByDepartureDate(departureDate,departure,destination);
    }
    public List<Plane> getPlaneByAirline(String airlineId) {
        return searchService.getPlaneByAirline(airlineId);
    }

    public List<Location> getLocationByRegion(Region region) {
        return searchService.getLocationByRegion(region);
    }

    public List<Flight> getAllFlight() {
        return searchService.getAllFlight();
    }
    public List<Plane> getPlaneByAvailableSeat(String planeNumber, String departure, String destination,
                                               Date departureDate, ClassType type, int numberOfSeat){
        return searchService.getPlaneByAvailableSeat(planeNumber,departure,destination,departureDate,type,numberOfSeat);
    }
    public List<Airline> getAllAirline() {
        return searchService.getAllAirline();
    }
    public Airline getAirlineByName(String name) {
        return searchService.getAirlineByName(name);
    }
    public List<Location> getAllLocation() {
        return searchService.getAllLocation();
    }
}
