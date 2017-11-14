package com.realdolmen.group7.domain.booking;

import com.realdolmen.group7.domain.search.Plane;
import com.realdolmen.group7.domain.search.Seat;

import javax.persistence.*;
import java.awt.print.Book;


/**
 * Created by ESOBG49 on 6/11/2017.
 */
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    @OneToOne
    private Plane plane;

    @OneToOne
    private Seat seat;

    @ManyToOne
    private Booking booking;

    public Ticket() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
