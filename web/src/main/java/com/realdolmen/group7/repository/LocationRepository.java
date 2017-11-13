package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.search.Airline;
import com.realdolmen.group7.domain.search.Location;
import com.realdolmen.group7.domain.search.Region;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LocationRepository {
    @PersistenceContext
    EntityManager em;


    public List<Location> findAllLocation() {
        return em.createQuery("select l from Location l", Location.class).getResultList();
    }

    public List<Location> getLocationByRegion(Region region){
        return em.createQuery("select l from Location l where l.region=:args", Location.class).setParameter("args", region).getResultList();
    }
}
