package com.realdolmen.group7.domain.booking;

import com.realdolmen.group7.domain.payment.Payment;
import com.realdolmen.group7.domain.search.Flight;
import com.realdolmen.group7.domain.users.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by ESOBG49 on 6/11/2017.
 */
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    private Payment payment;

    @Column(nullable = false)
    @OneToMany
    private List<Ticket> tickets;

    //private List<TogethAirPromotion> togethAirPromotions;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date bookingDate;

    @ManyToMany
    @JoinTable(name = "booking_flight", joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id"))
    private List<Flight> flights;


}
