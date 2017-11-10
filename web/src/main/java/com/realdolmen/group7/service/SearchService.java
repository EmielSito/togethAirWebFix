package com.realdolmen.group7.service;

import com.realdolmen.group7.domain.search.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by ESOBG49 on 7/11/2017.
 */
public interface SearchService {


   List<Plane> findPlaneByAvailableSeat(ClassType type, String departure, String destination, Date departureDate, int numberOfSeat);
   List<Plane> findByDepartureDate(String departure, String destination, Date departureDate);
   List<Location> getLocationByRegion(Region region);
   List<Flight> getAllFlight();
   Set<Region>getAllRegions();
   //List<Plane> getPlaneByAirline(String AirlineId);


}
