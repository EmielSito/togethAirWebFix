package com.realdolmen.group7.domain.search;

import com.realdolmen.group7.domain.payment.VolumeDiscount;

import javax.persistence.*;
import java.util.*;

/**
 * Created by ESOBG49 on 6/11/2017.
 */
@Entity
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "plane", fetch = FetchType.EAGER)
    private Set<Seat> seats = new LinkedHashSet<>();

    @ManyToOne
    private Flight flight;

    @OneToMany(mappedBy = "plane", fetch = FetchType.EAGER)
    private Set<VolumeDiscount> discount=new LinkedHashSet<>();

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date departureDate;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date arrivalDate;

    private String planeNumber;

    public void setId(Long id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Long getId() {
        return id;
    }

    public Set<VolumeDiscount> getDiscount() {
        return discount;
    }

    public void setDiscount(Set<VolumeDiscount> discount) {
        this.discount = discount;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public void setPlaneNumber(String planeNumber) {
        this.planeNumber = planeNumber;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }
}
