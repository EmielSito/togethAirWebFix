package com.realdolmen.group7.domain.payment;


import com.realdolmen.group7.domain.search.Plane;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class VolumeDiscount {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Plane plane;

    private int numberOfTickets;

    private double percent;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    @Override
    public String toString() {
        return "VolumeDiscount{" +
                "id=" + id +
                ", plane=" + plane +
                ", numberOfTickets=" + numberOfTickets +
                ", percent=" + percent +
                '}';
    }
}
