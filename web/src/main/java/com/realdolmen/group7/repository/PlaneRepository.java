package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.search.Flight;
import com.realdolmen.group7.domain.search.Plane;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PlaneRepository implements Serializable {

    @PersistenceContext
    EntityManager em;


    public List<Plane> findByDepartureDate(String departureDate, String departure, String destination){
        return em.createQuery("select p from Flight f join f.planes p where f.departure " +
                "=:args1 and f.destination =:args2 and p.departureDate=:args3",Plane.class).setParameter("args1",departure)
                .setParameter("args2",destination).setParameter("args3",departureDate).getResultList();
    }

    public List<Plane> findPlaneByAirline(String airlineId){
        return em.createQuery("select p from Airline a join a.flights f join f.planes p where a.airlineId =:args",Plane.class)
                .setParameter("args",airlineId)
                .getResultList();
    }


    public Plane findPlaneById(String planeNumber ){
        return em.find(Plane.class, planeNumber);
    }

}
