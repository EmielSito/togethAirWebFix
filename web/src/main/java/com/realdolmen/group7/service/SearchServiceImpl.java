package com.realdolmen.group7.service;

import com.realdolmen.group7.domain.search.*;
import com.realdolmen.group7.repository.*;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class SearchServiceImpl implements Serializable {

    @Inject
    private FlightRepository flightRepository;
    @Inject
    private PlaneRepository planeRepository;
    @Inject
    private SeatRepository seatRepository;
    @Inject
    private LocationRepository locationRepository;
    @Inject
    private AirlineRepository airlineRepository;

    
    public List<Seat> getAvailableSeat(String planeNumber, String departure, String destination, Date departureDate, ClassType type) {
        return seatRepository.findAvailableSeatsByClassType(planeNumber, type);

    }

    
    public List<Plane> getByDepartureDate(Date departureDate, String departure, String destination) {
        return planeRepository.findByDepartureDate(departureDate, departure, destination);

    }

    
    public List<Plane> getPlaneByAirline(String airlineId) {
        return planeRepository.findPlaneByAirline(airlineId);
    }

    
    public List<Location> getLocationByRegion(Region region) {
        return locationRepository.getLocationByRegion(region);
    }

    
    public List<Flight> getAllFlight() {
        return flightRepository.findAllFlights();
    }


    public List<Plane> getPlaneByAvailableSeat(String departureDate, String departure, String destination, ClassType type, int numberOfSeat) {
        List<Plane> planes =planeRepository.findByDepartureDateWithoutTime(departureDate,departure,destination);
        List<Seat> seats;

        List<Plane> newList = new ArrayList<>();

           for(Plane p:planes) {
               seats = seatRepository.findAvailableSeatsByClassType(p.getPlaneNumber(), type);
               if (seats.size() >= numberOfSeat) {
                   System.out.println("//////////////////////////////////////////////////////" + p.getId());
                   newList.add(p);

               }
           }
        System.out.println("//////////////////////////////////////////////////////" + newList.size());

        return newList;
    }

    
    public List<Airline> getAllAirline() {
        return airlineRepository.findAllAirline();
    }

    
    public Airline getAirlineByName(String name) {
        return airlineRepository.findByName(name);
    }

    
    public List<Location> getAllLocation() {
        return locationRepository.findAllLocation();
    }


    public List<Region> getAllRegions() {
        return Arrays.asList(Region.values());
    }

}
