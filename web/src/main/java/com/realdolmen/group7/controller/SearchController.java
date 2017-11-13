package com.realdolmen.group7.controller;


import com.realdolmen.group7.domain.search.*;
import com.realdolmen.group7.service.SearchServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.*;

@Named
@SessionScoped
public class SearchController {
    @Inject
    private SearchServiceImpl searchService;

    private Region test;
    List<String> locations = new ArrayList<>();
    private boolean business;
    private boolean economy;

    @PostConstruct
    public void prepareCheckBox() {
        this.business = true;
    }
    public Region getTest() {
        return test;
    }

    public void setTest(Region test) {
        this.test = test;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public boolean isBusiness() {
        return business;
    }

    public void setBusiness(boolean business) {
        this.business = business;
    }

    public boolean isEconomy() {
        return economy;
    }

    public void setEconomy(boolean economy) {
        this.economy = economy;
    }

    public List<Plane> planeListByDeparturedate(String departure, String destination, Date departureDate){
       return searchService.findByDepartureDate(departure, destination, departureDate);

    }
    public List<Plane> planeList(ClassType type, String departure, String destination, Date departureDate, int numberOfSeat){
       return searchService.findPlaneByAvailableSeat(type,departure,destination,departureDate,numberOfSeat);
    }
    @Transactional
    public List<Location> getLocationByRegion(Region region){
        return searchService.getLocationByRegion(region);
    }
    public List<Flight> getAllFlight(){
        return searchService.getAllFlight();
    }
    public List<Region> getAllRegions(){return searchService.getAllRegions();}

    public void getChangeLocation(AjaxBehaviorEvent event){
        Region region=null;

        //locationMap.put("region",getLocationByRegion(region));
        List<Location> tempLocations = getLocationByRegion(test);
        locations = new ArrayList<>();

        for(Location location : tempLocations){
            locations.add(location.getAirportName());
        }

        //getLocationByRegion(test);
    }
    public void onActiveStatusChange() {
        if (business) economy = false;
    }

    public void onInactiveStatusChange() {
        if (economy) business = false;
    }

}
