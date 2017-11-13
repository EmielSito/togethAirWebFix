package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.search.Seat;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Named
public class BookingRepository {
    @PersistenceContext
    EntityManager em;



    public void chooseBySeatNumber (Seat seat) {
        em.merge(seat);
    }



}
