package com.realdolmen.group7.controller;

import com.realdolmen.group7.domain.payment.VolumeDiscount;
import com.realdolmen.group7.domain.search.Flight;
import com.realdolmen.group7.domain.search.Plane;
import com.realdolmen.group7.domain.search.Seat;
import com.realdolmen.group7.repository.PlaneRepository;
import com.realdolmen.group7.repository.VolumeDiscountRepository;
import com.realdolmen.group7.service.SearchServiceImpl;
import com.realdolmen.group7.service.pojo.FlightPojo;
import com.realdolmen.group7.util.DateUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.realdolmen.group7.util.AppStartupConfig.marginPercentage;

/**
 * Created by ESOBG49 on 11/10/2017.
 */
@Named
@SessionScoped
public class SearchResultController implements Serializable {

    private List<Plane> planes = new ArrayList<>();
    private List<FlightPojo> flightPojos = new ArrayList<>();
    private long selectedPlane;
    private Long planeId;
    private Plane plane;

    @Inject
    private SearchServiceImpl searchService;
    @Inject
    private VolumeDiscountRepository volumeDiscountRepository;
    @Inject
    private SearchController searchController;

    @Inject
    private PlaneRepository planeRepository;

    @PostConstruct
    public void init(){
        this.planes = searchController.getPlaneList();
    }

    public String getConvertedDate(Plane plane) {

        return DateUtils.longDateToStringDate(plane.getDepartureDate().getTime());

    }

    public List<FlightPojo> getFlightPojos() {

        int i = 0;
        for (Plane plane : searchController.getPlaneList()) {
            i++;
            FlightPojo flightPojo = new FlightPojo();


            Flight flight = plane.getFlight();


            flightPojo.setFlightNumber(flight.getFlightNumber());
            flightPojo.setAirline(flight.getAirline());
            flightPojo.setDeparture(flight.getDeparture());
            flightPojo.setDestination(flight.getDestination());
            flightPojo.setPlane(plane);

            List<Seat> seatList = new ArrayList<>(plane.getSeats());
            double profit = (seatList.get(0).getBasePrice()/100) * marginPercentage;
            flightPojo.setPrice(seatList.get(0).getBasePrice() + profit);

            // Get the available discounts for the plane
            List<VolumeDiscount> volumeDiscountList = volumeDiscountRepository.findVolumeDiscountByPlane(plane.getPlaneNumber());

            if (i < volumeDiscountList.size()) {
                flightPojo.setNumberOfTickets(volumeDiscountList.get(i).getNumberOfTickets());
                flightPojo.setPercentage(volumeDiscountList.get(i).getPercent());
            }



            // this list is for the search result listing all the flights
            flightPojos.add(flightPojo);
        }


        return flightPojos;
    }

    public void setFlightPojos(List<FlightPojo> flightPojos) {
        this.flightPojos = flightPojos;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }

    public long getSelectedPlane() {
        return selectedPlane;
    }

    public void setSelectedPlane(long selectedPlane) {
        this.selectedPlane = selectedPlane;
    }

    public Long getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Long planeId) {
        this.planeId = planeId;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public String bookNow(long planeId) {

        for(Plane p: planes) {
            if(p.getId() == planeId) {
                plane = p;
                break;
            }
        }

        return "details?faces-redirect=true";
    }

    public double getBasePrice(Plane plane){
        List<Seat> seats = this.convertSeatSetToList(plane.getSeats());
        return seats.get(0).getBasePrice();
    }

    private List<Seat> convertSeatSetToList(Set<Seat> seatSet){
        return new ArrayList<>(seatSet);
    }
}
