package com.realdolmen.group7.service;

import com.realdolmen.group7.domain.booking.Ticket;
import com.realdolmen.group7.repository.TicketRepository;

public class TicketService {

    private TicketRepository ticketRepository;

    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}
