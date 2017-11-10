package com.realdolmen.group7.repository;


import com.realdolmen.group7.domain.search.ClassType;
import com.realdolmen.group7.domain.search.Seat;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * Created by PMTBF30 on 7/11/2017.
 */
@Stateless
public class SeatRepository {

    @PersistenceContext
    EntityManager em;


    public Seat updateSeat (Seat seat) {
        return em.merge(seat);
    }

    public List<Seat> findAvailableSeatsByClassType(String planeNumber, String departure, String destination, Date departureDate,ClassType type){
        return em.createQuery("select s from Flight f join f.planes p join p.seats s where p.planeNumber=:args1 and f.departure=:args2 and " +
                "f.destination=:args3  and p.departureDate=:args4 and s.classType=:args5 and s.isAvailable=true",Seat.class).setParameter("args1",planeNumber)
                .setParameter("args2",departure).setParameter("args3",destination).setParameter("args4",departureDate)
                .setParameter("args5",type).getResultList();
    }
    public void updateAvailableSeat(){


    }




}
