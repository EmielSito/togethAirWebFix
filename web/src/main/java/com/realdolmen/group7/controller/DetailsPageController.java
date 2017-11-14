package com.realdolmen.group7.controller;

import com.realdolmen.group7.domain.search.Plane;
import com.realdolmen.group7.domain.search.Seat;
import com.realdolmen.group7.service.SearchServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * Created by PMTBF30 on 13/11/2017.
 */

@Named
@SessionScoped
public class DetailsPageController implements Serializable{

    private Plane selectedPlane;
    private int numberOfPassenger;

    @Inject
    private SearchServiceImpl searchService;

    @Inject
    private SearchController searchController;

    @Inject
    private SearchResultController searchResultController;

    @PostConstruct
    private void init(){

        System.out.println(searchResultController.getPlane().getPlaneNumber());
        this.selectedPlane = searchResultController.getPlane();
        this.numberOfPassenger = searchController.getNumberOfSeats();
    }

    public SearchServiceImpl getSearchService() {
        return searchService;
    }

    public void setSearchService(SearchServiceImpl searchService) {
        this.searchService = searchService;
    }

    public SearchController getSearchController() {
        return searchController;
    }

    public void setSearchController(SearchController searchController) {
        this.searchController = searchController;
    }

    public SearchResultController getSearchResultController() {
        return searchResultController;
    }

    public void setSearchResultController(SearchResultController searchResultController) {
        this.searchResultController = searchResultController;
    }

    public Plane getSelectedPlane() {
        return selectedPlane;
    }

    public int getNumberOfPassenger() {
        return numberOfPassenger;
    }

    public void setNumberOfPassenger(int numberOfPassenger) {
        this.numberOfPassenger = numberOfPassenger;
    }

    public void setSelectedPlane(Plane selectedPlane) {
        this.selectedPlane = selectedPlane;
    }

    public double getTotalPrice(){
        double result = 0.0;
        List<Seat> seats = convertSeatSetToList(this.selectedPlane.getSeats());
        for(int i = 0; i < this.getNumberOfPassenger(); i++){
            result += seats.get(i).getBasePrice();
        }

        return result;
    }

    public String getNumberPassengersInfo(){
        String messageBundle= FacesContext.getCurrentInstance().getApplication().getMessageBundle();
        ResourceBundle bundle = ResourceBundle.getBundle(messageBundle);
        if(this.getNumberOfPassenger()==1){
            String value = bundle.getString("details.price.totalone");
            return value;
        }

        else{
            String value = bundle.getString("details.price.totalone");
            return value;
        }
    }

    private List<Seat> convertSeatSetToList(Set<Seat> seatSet){
        return new ArrayList<>(seatSet);
    }
}
