package com.realdolmen.group7.repository;


import com.realdolmen.group7.domain.search.Flight;
import com.realdolmen.group7.domain.search.Location;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * Created by PMTBF30 on 7/11/2017.
 */

public class FlightRepository {


    @PersistenceContext
    EntityManager em;

    public List<Flight> findAllFlights() {
        return em.createQuery("select f from Flight f", Flight.class).getResultList();
    }

    public Flight findByDeparture(Location departure) {
        return em.find(Flight.class, departure);
    }

    public Flight findByDestination(Location destination) {
        return em.find(Flight.class, destination);
    }

    public Flight findByDepartureDate(Date departureDate) {
        return em.find(Flight.class, departureDate);
    }


}
