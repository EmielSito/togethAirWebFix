package com.realdolmen.group7.repository;

import com.realdolmen.group7.AbstractPersistenceTest;
import com.realdolmen.group7.domain.search.ClassType;
import com.realdolmen.group7.domain.search.Seat;
import com.realdolmen.group7.util.DateUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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

        //List<Seat> seatList = seatRepository.findAvailableSeatsByClassType("0","1","1",DateUtils.createDate("2017-11-10 16:25:51"), ClassType.BUSINESS);
    }

    @Test
    public void updateAvailableSeat() throws Exception {
    }

}