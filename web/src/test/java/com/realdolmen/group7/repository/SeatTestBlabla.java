package com.realdolmen.group7.repository;

import com.realdolmen.group7.AbstractPersistenceTest;
import com.realdolmen.group7.domain.search.ClassType;
import com.realdolmen.group7.domain.search.Flight;
import com.realdolmen.group7.domain.search.Seat;
import com.realdolmen.group7.repository.KevinsSeatSearchRepo;
import com.realdolmen.group7.util.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by PMTBF30 on 7/11/2017.
 */
public class SeatTestBlabla extends AbstractPersistenceTest {
   @Test
    public void candyCanBePersisted() throws Exception {
        Flight f = new Flight();
        em.persist(f);
        assertNotNull(f.getId());
    }

    @Test
    public void canFindSeatsByBunchOfParameters() {

        KevinsSeatSearchRepo r = new KevinsSeatSearchRepo();
        r.em = em;


        List<Seat> seats = r.findSeats("FL-3000",
                "London",
                "Brussels",
                DateUtils.createDate("2017-11-09"),
                ClassType.ECONOMIC);

        assertEquals(2, seats.size());

    }




}
