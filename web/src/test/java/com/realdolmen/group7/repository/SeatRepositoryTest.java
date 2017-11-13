package com.realdolmen.group7.repository;

import com.realdolmen.group7.AbstractPersistenceTest;
import com.realdolmen.group7.domain.search.ClassType;
import com.realdolmen.group7.domain.search.Seat;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SeatRepositoryTest extends AbstractPersistenceTest {

    private SeatRepository seatRepository;


    @Before
    public void setUp() throws Exception {
        seatRepository = new SeatRepository();
        seatRepository.em = em;
    }

    @Test
    public void updateSeat() throws Exception {
    }

    @Test
    public void findAvailableSeatsByClassType() throws Exception {

        List<Seat> seatList = seatRepository.findAvailableSeatsByClassType("54521",ClassType.BUSINESS);
    }

    @Test
    public void updateAvailableSeat() throws Exception {
    }

}