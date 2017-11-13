package com.realdolmen.group7.repository;

import com.realdolmen.group7.AbstractPersistenceTest;
import com.realdolmen.group7.domain.search.Airline;
import com.realdolmen.group7.domain.search.Flight;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by PMTBF30 on 12/11/2017.
 */
public class FlightRepositoryTest extends AbstractPersistenceTest{

    private FlightRepository flightRepository;

    @Before
    public void initializeRepository() {
        flightRepository = new FlightRepository();
        flightRepository.em = em;
    }

    @Test
    public void findAllFlights() throws Exception {
        List<Flight> flights = flightRepository.findAllFlights();
        assertEquals(3, flights.size());
    }

    @Test
    public void findByDepartureAndDestination() throws Exception {
        List<Flight> flights = flightRepository.findByDepartureAndDestination("Zaventem", "Imam Khomeini");
        assertEquals(2, flights.size());
    }

}