package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.search.Location;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by PMTBF30 on 10/11/2017.
 */
public class LocationRepository {

    @PersistenceContext
    EntityManager em;

    public List<Location> findAllLocation() {
        return em.createQuery("select f.departure.airportName from Flight f", Location.class).getResultList();
    }

}
