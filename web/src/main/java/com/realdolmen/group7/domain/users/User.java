package com.realdolmen.group7.domain.users;


import com.realdolmen.group7.domain.booking.Booking;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ESOBG49 on 6/11/2017.
 */
@Entity
//@Table(name = "user")
public class User extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*@OneToMany(mappedBy = "user")
    List<Booking> bookings;

    @ManyToOne
    private Booking booking;


    public User() {
        super();
    }

    public User(String email, String password) {
        super(email, password);
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   /* public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }*/
}
