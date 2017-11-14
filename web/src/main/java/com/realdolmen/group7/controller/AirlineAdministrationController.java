package com.realdolmen.group7.controller;


import com.realdolmen.group7.domain.search.Flight;
import com.realdolmen.group7.service.FlightService;
import com.realdolmen.group7.service.FlightServiceImpl;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;


@Named
@SessionScoped
public class AirlineAdministrationController implements Serializable {

    @Inject
    private FlightServiceImpl flightServiceImpl;




    public Flight getFlightByPlane(long planeId) {
        return flightServiceImpl.getFlightByPlane(planeId);
    }


    public Flight createFlight(Flight flight) {
        return flightServiceImpl.createFlight(flight);
    }


    public void deleteFlight(Flight flight) {
        flightServiceImpl.deleteFlight(flight);

    }


    public Flight updateFlight(Flight flight) {
        return flightServiceImpl.updateFlight(flight);
    }





}
