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

    @OneToMany(mappedBy = "plane")
    private List<Seat> seats;

    private String planeNumber;

    public List<VolumeDiscount> getDiscount() {
        return discount;
    }

    public void setDiscount(List<VolumeDiscount> discount) {
        this.discount = discount;
    }

    @OneToMany(mappedBy = "plane")
    private List<VolumeDiscount> discount=new ArrayList<>();

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date departureDate;

    private boolean volumeDiscountAvailable;

    @ManyToOne
    private Flight flight;

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

    public boolean isVolumeDiscountAvailable() {
        return volumeDiscountAvailable;
    }

    public void setVolumeDiscountAvailable(boolean volumeDiscountAvailable) {
        this.volumeDiscountAvailable = volumeDiscountAvailable;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }













}
