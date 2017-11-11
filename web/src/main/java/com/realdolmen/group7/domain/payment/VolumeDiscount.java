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

    private int numberOfTickets;

    private double percent;

    @ManyToOne
    private Plane plane;

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
                ", numberOfTickets=" + numberOfTickets +
                ", percent=" + percent +
                ", plane=" + plane +
                '}';
    }
}
