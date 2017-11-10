package com.realdolmen.group7.service;

import com.realdolmen.group7.domain.search.*;
import com.realdolmen.group7.repository.FlightRepository;
import com.realdolmen.group7.repository.LocationRepository;
import com.realdolmen.group7.repository.PlaneRepository;
import com.realdolmen.group7.repository.SeatRepository;


import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SearchServiceImpl implements SearchService {

    @Inject
    private FlightRepository flightRepository;
    @Inject
    private PlaneRepository planeRepository;
    @Inject
    private SeatRepository seatRepository;
    @Inject
    private LocationRepository locationRepository;


    @Override
    public List<Seat> getAvailableSeat(String planeNumber, String departure, String destination, Date departureDate, ClassType type) {
        return seatRepository.findAvailableSeatsByClassType(planeNumber, departure, destination, departureDate, type);

    }

    @Override
    public List<Plane> getByDepartureDate(Date departureDate, String departure, String destination) {
        return planeRepository.findByDepartureDate(departureDate, departure, destination);

    }

    @Override
    public List<Plane> getPlaneByAirline(String airlineId) {
        return planeRepository.findPlaneByAirline(airlineId);
    }

    @Override
    public List<Location> getLocationByRegion(Region region) {
        return locationRepository.getLocationByRegion(region);
    }
    @Override
    public List<Flight> getAllFlight() {
        return flightRepository.findAllFlights();
    }

    @Override
    public List<Plane> getPlaneByAvailableSeat(String planeNumber, String departure, String destination, Date departureDate, ClassType type, int numberOfSeat) {
        List<Plane> planes=planeRepository.findByDepartureDate(departureDate,departure,destination);
        List<Seat> seats;
        List<Plane>resultPlaneList=new ArrayList<>();
           for(Plane p:planes) {
               seats = seatRepository.findAvailableSeatsByClassType(p.getPlaneNumber(), departure, destination, departureDate, type);
               if (seats.size() >= numberOfSeat) {
                   resultPlaneList.add(p);
               }
           }
           return resultPlaneList;
    }

}
