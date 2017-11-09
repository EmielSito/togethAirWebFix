package com.realdolmen.group7.domain.search;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by ESOBG49 on 6/11/2017.
 */
@Entity
public class Plane {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String planeNumber;


    @Temporal(value = TemporalType.TIMESTAMP)
    private Date departureTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date departureDate;

    public long getId() {
        return id;
    }

    private int durationInMinutes;

    @OneToMany
    private List<Seat> seats;

    public String getPlaneNumber() {
        return planeNumber;
    }

    public void setPlaneNumber(String planeNumber) {
        this.planeNumber = planeNumber;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
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

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    private boolean volumeDiscountAvailable;









}
