package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.search.Plane;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * Created by PMTBF30 on 10/11/2017.
 */
public class PlaneRepository {

    @PersistenceContext
    EntityManager em;

    /*public List<Plane> findByDepartureDate(Date departureDate, String departure, String destination) {


    }*/

}
