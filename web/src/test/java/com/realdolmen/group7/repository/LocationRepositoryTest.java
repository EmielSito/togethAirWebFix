package com.realdolmen.group7.repository;

import com.realdolmen.group7.AbstractPersistenceTest;
import com.realdolmen.group7.domain.search.Location;
import com.realdolmen.group7.domain.search.Region;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by PMTBF30 on 12/11/2017.
 */
public class LocationRepositoryTest extends AbstractPersistenceTest {
    private LocationRepository locationRepository;

    @Before
    public void initializeRepository() {
        locationRepository = new LocationRepository();
        locationRepository.em = em;
    }

    @Test
    public void findAllLocation() throws Exception {
        List<Location> locations = locationRepository.findAllLocation();
        assertEquals(3, locations.size());
    }

    @Test
    public void getLocationByRegion() throws Exception {
        List<Location> locations = locationRepository.getLocationByRegion(Region.WESTERNASIA);
        assertEquals(1, locations.size());
    }

}