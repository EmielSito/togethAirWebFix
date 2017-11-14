package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.booking.Booking;
import com.realdolmen.group7.domain.search.Seat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BookingRepository {
    @PersistenceContext
    EntityManager em;

    public Booking save(Booking booking){
        em.persist(booking);
        return booking;
    }




}
