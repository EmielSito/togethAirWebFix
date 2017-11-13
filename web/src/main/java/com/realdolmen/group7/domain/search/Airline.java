package com.realdolmen.group7.domain.search;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PMTBF30 on 7/11/2017.
 */
@Entity
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String airlineId;
    private String airlineName;

    @OneToMany(mappedBy = "airline")
    private List<Flight> flights = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(String airlineId) {
        this.airlineId = airlineId;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }


    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", airlineId='" + airlineId + '\'' +
                ", airlineName='" + airlineName + '\'' +
                ", flights=" + flights +
                '}';
    }
}
