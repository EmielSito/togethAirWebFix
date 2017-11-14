package com.realdolmen.group7.controller;


import com.realdolmen.group7.domain.search.*;
import com.realdolmen.group7.service.SearchServiceImpl;
import org.hibernate.sql.SelectValues;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class SearchController implements Serializable {

    private List<Plane> planeList = new ArrayList<>();
    private String departure = "Zaventem";
    private String destination = "Imam Khomeini";
    private ClassType classType = ClassType.BUSINESS;
    private int numberOfSeats = 1;
    private Date departureDate;
    private Date returnDate;
    private String departureDateString="";
    private String returnDateString="";

    @Inject
    private SearchServiceImpl searchService;


    public List<Plane> getPlaneList() {
        return planeList;
    }

    public void setPlaneList(List<Plane> planeList) {
        this.planeList = planeList;
    }

    public SearchServiceImpl getSearchService() {
        return searchService;
    }

    public void setSearchService(SearchServiceImpl searchService) {
        this.searchService = searchService;
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

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getDepartureDateString() {
        return departureDateString;
    }

    public void setDepartureDateString(String departureDateString) {
        this.departureDateString = departureDateString;
    }

    public String getReturnDateString() {
        return returnDateString;
    }

    public void setReturnDateString(String returnDateString) {
        this.returnDateString = returnDateString;
    }

    public String findAirplanes(){

        planeList = searchService.getPlaneByAvailableSeat(departureDateString,departure,destination,classType,numberOfSeats);

        System.out.println(planeList.size());
        if(planeList.size() != 0){
            return "products?faces-redirect=true";
        }
        return "index.xhtml";
    }

    public String getByDepartureDateWithoutTime() {

        planeList = searchService.getPlaneByAvailableSeat(departureDateString,departure,destination,classType,numberOfSeats);
        if (planeList.size() != 0){
            return "searchResult?faces-redirect=true";
        } else {
            // TODO tell the user no planes are available
        }


        return null;
    }

    public List<ClassType> getClassTypes() {
        return Arrays.asList(ClassType.values());
    }

    public void onDepartureDateSelect(SelectEvent event){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        this.setDepartureDateString(format.format(event.getObject()).toString());
    }

    public void onReturnDateSelect(SelectEvent event){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        this.setReturnDateString(format.format(event.getObject()).toString());
    }

    public void printResult() {
        System.out.println(departure + " " + departureDateString + " " + destination + " " + returnDate
                + " " + numberOfSeats + " " + classType);

    }


        /*private Region region;
    List<String> locations = new ArrayList<>();
    private boolean business;
    private boolean economy;


    private List<Region> allRegions = new ArrayList<>();

    @PostConstruct
    public void prepareCheckBox() {
        this.business = true;
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
    }*/

}
