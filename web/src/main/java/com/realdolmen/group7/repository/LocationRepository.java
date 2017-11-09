package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.search.Location;
import com.realdolmen.group7.domain.search.Region;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by PMTBF30 on 7/11/2017.
 */
@Stateless
public class LocationRepository {

    @PersistenceContext
    EntityManager em;

    public Location findByRegion(Region region) {
        return em.find(Location.class, region);
    }
}
