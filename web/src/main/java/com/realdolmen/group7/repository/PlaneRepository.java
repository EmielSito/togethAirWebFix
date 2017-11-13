package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.search.Plane;
import com.realdolmen.group7.util.DateUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

public class PlaneRepository {

    @PersistenceContext
    EntityManager em;

    public List<Plane> findByDepartureDate(Date departureDate, String departure, String destination){
        return em.createQuery("select p from Flight f join f.planes p where f.departure.airportName " +
                " like :args1 and f.destination.airportName like :args2 and p.departureDate=:args3 and p.seats >= numberOfseats",Plane.class).setParameter("args1",departure)
                .setParameter("args2",destination).setParameter("args3",departureDate).getResultList();
    }

    /*
    *     public List<Plane> findByDepartureDate(Date departureDate, String departure, String destination){
        return em.createQuery("select p from Flight f join f.planes p join p.seats s where f.departure.airportName " +
                " like :args1 and f.destination.airportName like :args2 and p.departureDate=:args3 " +
                "and (select count(s) from s where s.isAvailable=true and s.classType=:args5)",Plane.class).setParameter("args1",departure)
                .setParameter("args2",destination).setParameter("args3",departureDate).setParameter("args5", type).getResultList();
    }
*/

    public List<Plane> findByDepartureDateWithoutTime(String departureDate, String departure, String destination){
        return em.createQuery("select p from Flight f join f.planes p where f.departure.airportName " +
                " like :args1 and f.destination.airportName like :args2 and p.departureDate BETWEEN :argDepartDate1 AND :argDepartDate2",Plane.class).setParameter("args1",departure)
                .setParameter("args2",destination).setParameter("argDepartDate1", DateUtils.createDateAndTime(departureDate+" 00:00:00")).setParameter("argDepartDate2",DateUtils.createDateAndTime(departureDate+" 23:59:59")).getResultList();
    }

    public List<Plane> findPlaneByAirline(String airlineId){
        return em.createQuery("select p from Airline a join a.flights f join f.planes p where a.airlineId =:args",Plane.class)
                .setParameter("args",airlineId)
                .getResultList();
    }

}
