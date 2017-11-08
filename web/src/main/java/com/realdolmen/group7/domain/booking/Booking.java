package com.realdolmen.group7.domain.booking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by ESOBG49 on 6/11/2017.
 */
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
/*

    @ManyToOne
    @Column(nullable = false)
    private User user;

    @OneToMany(mappedBy = "booking")
    private List<Flight> flights;

    @Column(nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private Payment payment;

    @Column(nullable = false)
    @OneToMany(mappedBy ="booking")
    private List<Ticket> tickets;

    //private List<TogethAirPromotion> togethAirPromotions;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date bookingDate;

*/



    public Booking() {
    }


}
