package com.realdolmen.group7.domain.search;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PMTBF30 on 7/11/2017.
 */
@Entity
public class Airline {
    @Id
    @GeneratedValue()
    private Long id;

    @OneToMany(mappedBy = "airline")
    private List<Flight> flights = new ArrayList<>();

    private String airlineId;
    private String name;

    public Long getId() {
        return id;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public String getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(String airlineId) {
        this.airlineId = airlineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", flights=" + flights +
                ", airlineId='" + airlineId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
