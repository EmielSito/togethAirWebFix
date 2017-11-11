package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.search.Airline;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by PMTBF30 on 7/11/2017.
 */

public class AirlineRepository {

    @PersistenceContext
    EntityManager em;

    public List<Airline> findAllAirline() {
        return em.createQuery("select a from Airline a", Airline.class).getResultList();
    }

    public Airline findByName(String name) {
        return  em.createQuery("select f.airline from Flight f", Airline.class).getSingleResult();
    }
}
