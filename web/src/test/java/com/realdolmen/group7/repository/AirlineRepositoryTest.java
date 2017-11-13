package com.realdolmen.group7.repository;

import com.realdolmen.group7.AbstractPersistenceTest;
import com.realdolmen.group7.domain.search.Airline;
import com.realdolmen.group7.domain.users.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by PMTBF30 on 12/11/2017.
 */
public class AirlineRepositoryTest extends AbstractPersistenceTest{

    private AirlineRepository airlineRepository;

    @Before
    public void initializeRepository() {
        airlineRepository = new AirlineRepository();
        airlineRepository.em = em;
    }

    @Test
    public void findAllAirline() throws Exception {
        List<Airline> airlines = airlineRepository.findAllAirline();
        assertEquals(3, airlines.size());

    }

    @Test
    public void findByName() throws Exception {
        Airline airline = airlineRepository.findByName("KLM");
        assertEquals("KLM156", airline.getAirlineId());
    }

}