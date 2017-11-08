package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.search.Airline;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by PMTBF30 on 7/11/2017.
 */
@Stateless
public class AirlineRepository {

    @PersistenceContext
    EntityManager em;

    public Airline findByName(String name) {
        return em.find(Airline.class, name);
    }


}
