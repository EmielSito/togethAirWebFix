package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.search.Seat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BookingRepository {
    @PersistenceContext
    EntityManager em;

    public List<Seat> availableSeat(){
        return em.createQuery("select f.planes.seats from Flight f where f.planes.seats.isAvailable LIKE :args",Seat.class).
                setParameter("args",true).getResultList();
    }

    public int chooseBySeatNumber (String seatNumber) {
        return  em.createQuery("update Flight.plane.seats SET Flight.plane.seats.isAvailable = :args1 " +
                "where f.planes.seats.seatNumber=:args2").setParameter("args1",false)
                .setParameter("args2",seatNumber).executeUpdate();
    }


}
