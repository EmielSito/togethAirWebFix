package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.search.Airline;
import com.realdolmen.group7.repository.experiment.GenericDao;

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

    public Object findById(String airlineId) {
        return em.find(Airline.class, airlineId);
    }

    public Airline findByName(String name) {
        return em.find(Airline.class, name);
    }

    public void save(Airline airline) {
        em.persist(airline);
    }

    public void update(Airline airline) {
        em.merge(airline);
    }

    public void delete(Airline airline) {
        em.remove(airline);
    }

    public void deleteById(String airlineId) {
        em.remove(findById(airlineId));

    }
}
