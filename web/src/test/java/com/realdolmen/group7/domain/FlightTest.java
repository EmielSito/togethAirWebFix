package com.realdolmen.group7.domain;

import com.realdolmen.group7.AbstractPersistenceTest;
import com.realdolmen.group7.domain.search.Flight;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by PMTBF30 on 7/11/2017.
 */

public class FlightTest extends AbstractPersistenceTest {
   @Test
    public void candyCanBePersisted() throws Exception {
        Flight f = new Flight();

        em.persist(f);
        assertNotNull(f.getId());


    }
}
