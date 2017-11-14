package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.booking.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class TicketRepository {

    @PersistenceContext
    EntityManager entityManager;



    public Ticket save(Ticket ticket){
        entityManager.persist(ticket);
        return ticket;
    }

    public void update(Ticket ticket) {
        entityManager.merge(ticket);
    }
}
