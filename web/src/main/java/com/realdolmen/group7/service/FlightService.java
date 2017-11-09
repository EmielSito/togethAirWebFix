package com.realdolmen.group7.service;

import com.realdolmen.group7.domain.search.Flight;
import com.realdolmen.group7.domain.search.Location;
import com.realdolmen.group7.domain.search.Region;

import java.util.Date;
import java.util.List;

/**
 * Created by ESOBG49 on 7/11/2017.
 */
public interface FlightService {

    List<Flight> getFlights(Location destination);

    List<Flight> getFlights(Date departureDate);

    List<Location> getLocations();

    List<Location> getLocations(Region region);



}
