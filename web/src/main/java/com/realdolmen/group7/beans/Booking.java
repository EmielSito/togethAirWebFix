package com.realdolmen.group7.beans;

import java.util.ArrayList;
import java.util.List;

public class Booking {

    private List<Ticket> ticketList = new ArrayList<>();

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public void addTicket(Ticket ticket){
        this.ticketList.add(ticket);
    }

    public void removeTicket(Ticket ticket){
        this.ticketList.remove(ticket);
    }
}
