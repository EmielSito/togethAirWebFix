package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.booking.Booking;
import com.realdolmen.group7.domain.search.Flight;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Date;
import java.util.List;

public class BookingRepository {
    @PersistenceContext
    EntityManager em;

    public List<Booking> findBookingByDay(Date date){
        return  em.createQuery("select b from Booking b where b.bookingDate=:args",Booking.class)
                .setParameter("args",date).getResultList();
    }

}
