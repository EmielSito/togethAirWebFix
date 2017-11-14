package com.realdolmen.group7.domain.booking;


import com.realdolmen.group7.domain.payment.Payment;
import com.realdolmen.group7.domain.search.Flight;
import com.realdolmen.group7.domain.users.User;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ESOBG49 on 6/11/2017.
 */

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY)
    private Payment payment;

    @Column(nullable = false)
    @OneToMany(mappedBy = "booking")
    private List<Ticket> tickets = new ArrayList<>();

    //private List<TogethAirPromotion> togethAirPromotions;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date bookingDate;

    @ManyToMany
    @JoinTable(name = "booking_flight", joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id"))
    private List<Flight> flights = new ArrayList<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }


}
