package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.booking.Booking;
import com.realdolmen.group7.domain.search.Seat;
import com.realdolmen.group7.domain.booking.Booking;
import com.realdolmen.group7.domain.search.Flight;
import com.realdolmen.group7.util.DateUtils;


import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Date;
import java.util.List;
@Named
public class BookingRepository {
    @PersistenceContext
    EntityManager em;

    public Booking save(Booking booking){
        em.persist(booking);
        return booking;
    }

    public List<Booking> findBookingByDay(Date date){
        return  em.createQuery("select b from Booking b where b.bookingDate BETWEEN :argDate1 AND :argDate2",Booking.class)
                .setParameter("argDate1", DateUtils.createDateAndTime(date+" 00:00:00")).setParameter("argDate2",DateUtils.createDateAndTime(date+" 23:59:59")).getResultList();
    }

}
