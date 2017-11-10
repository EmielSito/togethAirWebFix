package com.realdolmen.group7.service;

import com.realdolmen.group7.domain.search.*;

import java.util.Date;
import java.util.List;

/**
 * Created by ESOBG49 on 7/11/2017.
 */
public interface SearchService {


   public List<Seat> getAvailableSeat(String planeNumber, String departure, String destination, Date departureDate, ClassType type);

   public List<Plane> getByDepartureDate(Date departureDate, String departure, String destination);

   public List<Plane> getPlaneByAirline(String airlineId);

   public List<Location> getLocationByRegion(Region region);

   public List<Flight> getAllFlight();

   public List<Plane> getPlaneByAvailableSeat(String planeNumber, String departure, String destination, Date departureDate, ClassType type, int numberOfSeat);

   public List<Airline> getAllAirline();

   public Airline getAirlineByName(String name);

   public List<Location> getAllLocation();


}