package com.realdolmen.group7.service;

import com.realdolmen.group7.domain.search.*;
import com.realdolmen.group7.repository.FlightRepository;
import com.realdolmen.group7.repository.LocationRepository;


import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SearchServiceImpl implements SearchService {

    @Inject
    private FlightRepository flightRepository;

    private LocationRepository locationRepository;



    @Override
    public List<Plane> findPlaneByAvailableSeat(ClassType type, String departure, String destination, Date departureDate, int numberOfSeat) {
        List<Seat> seatList = new ArrayList<>();
        List<Plane> planes = findByDepartureDate(departure, destination, departureDate);
        List<Plane> resultPlaneList = new ArrayList<>();
        for (Plane p : planes) {
            p.getSeats().forEach(s -> {
                if (s.getClassType() == type) {
                    seatList.add(s);
                }
                if (seatList.size() >= numberOfSeat) {
                    resultPlaneList.add(p);
                }
            });
        }

        return resultPlaneList;
    }


    public List<Plane> findByDepartureDate(String departure, String destination, Date departureDate) {

        List<Plane> planes = new ArrayList<>();
        List<Flight> flights = flightRepository.findByDeparture(departure, destination);
        for (Flight f : flights) {
            f.getPlanes().forEach(p -> {
                if (p.getDepartureDate() == departureDate) {
                    planes.add(p);
                }
            });
        }

        return planes;
    }

    @Override
    public List<Location> getLocationByRegion(Region region) {
        List<Location> locations=new ArrayList<>();
        List<Location> locationList=locationRepository.findAllLocation();
        for(Location l:locationList){
            if(l.getRegion().equals(region)){
                locations.add(l);
            }
        }
       return locations;
    }

    @Override
    public List<Flight> getAllFlight() {
        return  flightRepository.findAllFlights();
    }

    @Override
    public List<Plane> getPlaneByAirline(String AirlineId) {
        return null;
    }

}
