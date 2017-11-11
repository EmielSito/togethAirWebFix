package com.realdolmen.group7.repository;


import com.realdolmen.group7.domain.search.ClassType;
import com.realdolmen.group7.domain.search.Seat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

public class KevinsSeatSearchRepo {
    @PersistenceContext
    EntityManager em;

    List<Seat> findSeats(String planeNumber, String departure, String destination, Date departureDate, ClassType type) {
        return em.createQuery("select s from Seat s where s.isAvailable = true", Seat.class).getResultList();


//        select s
//        from Flight f
//        join f.planes p
//        join p.seats s
//        where f.departure = :dep
//        and f.destination = :dest
//        and p.departureDate = :depdate
//        and p.planeNumber = :pnum
//        and s.classType = :type
//        and s.isAvailable = true
    }


}
