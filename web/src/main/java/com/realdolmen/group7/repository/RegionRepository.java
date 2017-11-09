package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.search.Flight;
import com.realdolmen.group7.domain.search.Location;
import com.realdolmen.group7.domain.search.Region;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by PMTBF30 on 7/11/2017.
 */
@Stateless
public class RegionRepository {

    @PersistenceContext
    EntityManager em;

    public List<Region> findAllRegions() {
        return em.createQuery("select r from Region r", Region.class).getResultList();
    }

    public Region findByName(Region region) {
        return em.find(Region.class, region);
    }


}
