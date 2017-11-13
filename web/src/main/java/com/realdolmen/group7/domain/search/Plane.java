package com.realdolmen.group7.domain.search;

import com.realdolmen.group7.domain.payment.VolumeDiscount;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ESOBG49 on 6/11/2017.
 */
@Entity
public class Plane {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "plane", fetch = FetchType.EAGER)
    private List<Seat> seats = new ArrayList<>();

    @ManyToOne
    private Flight flight;

    @OneToMany(mappedBy = "plane", fetch = FetchType.EAGER)
    private List<VolumeDiscount> discount=new ArrayList<>();

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

    public List<VolumeDiscount> getDiscount() {
        return discount;
    }

    public void setDiscount(List<VolumeDiscount> discount) {
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

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", seats=" + seats +
                ", flight=" + flight +
                ", discount=" + discount +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", planeNumber='" + planeNumber + '\'' +
                '}';
    }
}
