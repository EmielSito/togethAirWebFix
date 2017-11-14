package com.realdolmen.group7.service;

import com.realdolmen.group7.domain.search.Flight;
import com.realdolmen.group7.repository.FlightRepository;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class FlightServiceImpl implements FlightService,Serializable {

    @Inject
    private FlightRepository flightRepository;


    @Override
    public Flight getFlightByPlane(long planeId) {
        return flightRepository.getFlightByPlane(planeId);
    }

    @Override
    public Flight createFlight(Flight flight) {
        return flightRepository.createFlight(flight);
    }

    @Override
    public void deleteFlight(Flight flight) {
        flightRepository.deleteFlight(flight);

    }

    @Override
    public Flight updateFlight(Flight flight) {
        return flightRepository.updateFlight(flight);
    }
}
