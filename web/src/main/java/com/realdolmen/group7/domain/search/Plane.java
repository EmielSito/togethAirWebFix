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
    private Long id;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date departureDate;

    @OneToMany
    private List<Seat> seats;

    private String planeNumber;

    private int durationInMinutes;

    private boolean volumeDiscountAvailable;

    public long getId() {
        return id;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public void setPlaneNumber(String planeNumber) {
        this.planeNumber = planeNumber;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public boolean isVolumeDiscountAvailable() {
        return volumeDiscountAvailable;
    }

    public void setVolumeDiscountAvailable(boolean volumeDiscountAvailable) {
        this.volumeDiscountAvailable = volumeDiscountAvailable;
    }
}
