package com.realdolmen.group7.repository;

import com.realdolmen.group7.AbstractPersistenceTest;
import com.realdolmen.group7.domain.search.Plane;
import com.realdolmen.group7.util.DateUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by PMTBF30 on 12/11/2017.
 */
public class PlaneRepositoryTest extends AbstractPersistenceTest{

    private PlaneRepository planeRepository;

    @Before
    public void initializeRepository() {
        planeRepository = new PlaneRepository();
        planeRepository.em = em;
    }

    @Test
    public void findByDepartureDate() throws Exception {
        List<Plane> planes = planeRepository.findByDepartureDate(DateUtils.createDateAndTime("2018-10-15 11:00:00"), "Zaventem", "Imam Khomeini");
        assertEquals(1, planes.size());
    }

    @Test
    public void findPlaneByAirline() throws Exception {
        List<Plane> planes = planeRepository.findPlaneByAirline("KLM156");
        assertEquals(2, planes.size());
    }

}