package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.search.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

/**
 * Created by PMTBF30 on 7/11/2017.
 */
@Stateless
public class FlightRepository {

    @PersistenceContext
    EntityManager em;

    public List<Flight> findAllFlights() {
        return em.createQuery("select f from Flight f", Flight.class).getResultList();
    }

    //airportName for departure and destination locations
    public List<Flight> findByDepartureAndDestination(String departure, String destination) {
        return em.createQuery("select f from Flight f where f.departure.airportName LIKE :args1 AND  " +
                "f.destination.airportName LIKE :args2 ", Flight.class)
                .setParameter("args1", departure).setParameter("args2", destination).getResultList();
    }

}
