package com.realdolmen.group7.service;

import com.realdolmen.group7.domain.search.*;
import com.realdolmen.group7.repository.FlightRepository;


import javax.inject.Inject;
import java.util.*;


public class SearchServiceImpl implements SearchService {

    @Inject
    private FlightRepository flightRepository;



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
        List<Location> locationList=flightRepository.findAllLocation();
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
    public Set<Region> getAllRegions() {
        Set<Region>regions=new HashSet<>();
        regions.add(Region.EUROPE);
        regions.add(Region.AFRICA);
        regions.add(Region.ASIA);
        regions.add(Region.USA);
        regions.add(Region.AUSTRALIA);

        return regions;
    }

//    @Override
//    public List<Plane> getPlaneByAirline(String AirlineId) {
//        List<Plane>planes=new
//        return null;
//    }




}
