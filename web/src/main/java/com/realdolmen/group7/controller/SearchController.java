package com.realdolmen.group7.controller;


import com.realdolmen.group7.domain.search.ClassType;
import com.realdolmen.group7.domain.search.Plane;
import com.realdolmen.group7.service.SearchServiceImpl;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class SearchController {

    @Inject
   private SearchServiceImpl searchService;

    public List<Plane> planeListByDeparturedate(String departure, String destination, Date departureDate){
       return searchService.findByDepartureDate(departure, destination, departureDate);

    }
    public List<Plane> planeList(ClassType type, String departure, String destination, Date departureDate, int numberOfSeat){
       return searchService.findPlaneByAvailableSeat(type,departure,destination,departureDate,numberOfSeat);
    }

}
