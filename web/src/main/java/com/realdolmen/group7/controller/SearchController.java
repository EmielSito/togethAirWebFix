package com.realdolmen.group7.controller;


import com.realdolmen.group7.domain.search.*;
import com.realdolmen.group7.service.SearchServiceImpl;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class SearchController implements Serializable {


    private List<Plane> planeList = new ArrayList<>();

    @Inject
    private SearchServiceImpl searchService;

    private String departureDate;
    private String departure;
    private String destination;
    private ClassType classType;
    private int numberOfSeats;


    private Region region;
    List<String> locations = new ArrayList<>();
    private boolean business;
    private boolean economy;


    private List<Region> allRegions = new ArrayList<>();

    @PostConstruct
    public void prepareCheckBox() {
        this.business = true;
    }




    public String getByDepartureDateWithoutTime() {
        // get list of planes then go to searchResultController

        if (economy) {
            classType = ClassType.ECONOMY;
        } else {
            classType = ClassType.BUSINESS;
        }


        planeList = searchService.getPlaneByAvailableSeat(departureDate,departure,destination,classType,numberOfSeats);




        if (planeList.size() != 0){
            return "searchResult?faces-redirect=true";
        } else {
            // TODO tell the user no planes are available
        }


        return null;
    }


    public List<Plane> getPlaneByAirline(String airlineId) {
        return searchService.getPlaneByAirline(airlineId);
    }

    @Transactional
    public List<Location> getLocationByRegion(Region region) {
        return searchService.getLocationByRegion(region);
    }

    public List<Flight> getAllFlight() {
        return searchService.getAllFlight();
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public List<Airline> getAllAirline() {
        return searchService.getAllAirline();
    }

    public Airline getAirlineByName(String name) {
        return searchService.getAirlineByName(name);
    }

    public List<Location> getAllLocation() {
        return searchService.getAllLocation();
    }

    public List<Region> getAllRegions() {
        return allRegions;
    }

    public void setAllRegions(List<Region> allRegions) {
        this.allRegions = searchService.getAllRegions();;
    }

    public List<Plane> getPlaneList() {
        return planeList;
    }

    public void setPlaneList(List<Plane> planeList) {
        this.planeList = planeList;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
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

    public void getChangeLocation(AjaxBehaviorEvent event){
        Region region=null;

        //locationMap.put("region",getLocationByRegion(region));
        List<Location> tempLocations = getLocationByRegion(region);
        locations = new ArrayList<>();

        for(Location location : tempLocations){
            locations.add(location.getAirportName());
        }
    }


    public void businessClassIsSelected() {
        if (business) economy = false;
    }

    public void economyClassIsSelected() {
        if (economy) business = false;
    }

}
