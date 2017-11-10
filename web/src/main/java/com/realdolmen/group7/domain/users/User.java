package com.realdolmen.group7.domain.users;

import com.realdolmen.group7.domain.booking.Booking;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ESOBG49 on 6/11/2017.
 */
@Entity
public class User extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
/*
    @OneToMany(mappedBy = "user")
    List<Booking> bookings;


    public User() {
        super();
    }

    public User(String email, String password) {
        super(email, password);
    }


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
    */
}
