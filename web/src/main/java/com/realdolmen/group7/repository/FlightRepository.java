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

    public List<Flight> findByDeparture(String departure, String destination) {//departure and destination have the same List
        return  em.createQuery("select f.departure.airportName, f.destination.airportName " +
                "from Flight f where f.departure.airportName LIKE :args1 AND  f.destination.airportName " +
                "LIKE :args2 ",Flight.class)
                .setParameter("args1",departure).setParameter("args2",destination).getResultList();
    }


    public List<Location> findAllLocation() {
        return em.createQuery("select f.departure.airportName from Flight f", Location.class).getResultList();
    }



}
