package com.realdolmen.group7.repository;


import com.realdolmen.group7.domain.search.ClassType;
import com.realdolmen.group7.domain.search.Seat;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by PMTBF30 on 7/11/2017.
 */
@Stateless
public class SeatRepository {

    @PersistenceContext
    EntityManager em;

    public Seat findByClassType(ClassType type) {
        return em.find(Seat.class, type);
    }

    public Seat findByNumber(String number) {
        return em.find(Seat.class, number);
    }
}
