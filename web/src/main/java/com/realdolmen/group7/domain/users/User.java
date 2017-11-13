package com.realdolmen.group7.domain.users;
import com.realdolmen.group7.domain.booking.Booking;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ESOBG49 on 6/11/2017.
 */
@Entity
public class User /*extends Person*/ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user")
    List<Booking> bookings = new ArrayList<>();

    private String email;

    private String password;

    public Long getId() {
        return id;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", bookings=" + bookings +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
