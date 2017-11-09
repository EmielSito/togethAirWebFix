package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.search.*;

import com.realdolmen.group7.domain.search.Flight;
import com.realdolmen.group7.domain.search.Location;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * Created by PMTBF30 on 7/11/2017.
 */

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

        public List<Location> findAllLocation() {
            return em.createQuery("select l from Location l", Location.class).getResultList();
        }*/

    public Seat findByClassType(ClassType type) {
        return (Seat)em.createQuery("select f from Flight f where f.plane.seat.classType LIKE :args").setParameter("args",type).getSingleResult();

    }

    public Seat findByNumber(String number) {
        return (Seat)em.createQuery("select f from Flight " +
                "f where f.plane.seat.seatNumber LIKE :args").setParameter("args",number).getSingleResult();
    }

   public Flight getFlightByPlane(long planeId) {
       return (Flight)em.createQuery("select fp from flight_plane fp where fp.planeId = :arg").setParameter("arg", planeId).getSingleResult();
   }
}
