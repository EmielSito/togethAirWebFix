package com.realdolmen.group7.controller;

import com.realdolmen.group7.domain.search.*;
import com.realdolmen.group7.service.SearchService;
import com.realdolmen.group7.service.pojo.FlightPojo;
import com.realdolmen.group7.util.DateUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ESOBG49 on 11/10/2017.
 */
@Named
@RequestScoped
public class SearchResultController implements Serializable {



    private List<Plane> planes;


    private List<FlightPojo> flightPojos;



    @PostConstruct
    // TODO THIS METHOD IS ONLY FOR TESTING   REMOVE WHEN IN PRODUCTION
    public void init(){
        this.flightPojos = new ArrayList<>();
        this.planes = new ArrayList<>();


        Random random = new Random();



        for (int i=0;i<=10;i++) {
            Plane p = new Plane();
            BigDecimal bigDecimal = new BigDecimal(random.nextDouble()+random.nextInt(200)+100);
            double seatPrice = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();

            //p.setId(i);
            p.setPlaneNumber("TESTPLANE" + String.valueOf(i));
            p.setDepartureDate(DateUtils.createDate("2017-" + String.valueOf(random.nextInt(12)) + "-" + String.valueOf(random.nextInt(30))));


            //p.setDurationInMinutes(random.nextInt(60)+60);


            List<Seat> seatList = new ArrayList<>();
            for (int j=0; j<30; j++){
                Seat seat = new Seat();
                if (j<=15) {
                    seat.setBasePrice(seatPrice);
                    seat.setClassType(ClassType.ECONOMY);
                }
                if (j>=16 && j<=20) {
                    seat.setBasePrice(seatPrice+100);
                    seat.setClassType(ClassType.BUSINESS);
                }
                seat.setSeatNumber(String.valueOf(j));
                seatList.add(seat);
            }
            // seats are placed into plane
            p.setSeats(seatList);

            planes.add(p);

        }



    }


    @Inject
    private SearchService searchService;


    public String getConvertedDate(Plane plane){

                return DateUtils.longDateToStringDate(plane.getDepartureDate().getTime());

    }

    /*public List<FlightPojo> getFlightPojos() {


        // TODO  lets try to get the controller that is used on the searchpage and pass on to the next page for processing
        FacesContext context = FacesContext.getCurrentInstance();
        SearchController searchController = (SearchController) context.getApplication().evaluateExpressionGet(context, "#{bean1}", SearchController.class);

        // TODO lets see if this will work

        int i=0;
        for (Plane plane : planes) {
            i++;
            FlightPojo flightPojo = new FlightPojo();

            //TODO this is for production
            *//*Flight flight = searchService.getFlightByPlane(plane.getId()); // get the flight
            flightPojo.setAirline(flight.getAirline());
            flightPojo.setDeparture(flight.getDeparture());
            flightPojo.setDestination(flight.getDestination());*//*
            Random random = new Random();

            //TODO this is for testing
            Airline airline = new Airline();
            airline.setName("FAKE AIRLINE "+String.valueOf(i));
            flightPojo.setAirline(airline);

            flightPojo.setFlightNumber("FAKE NUMBER "+String.valueOf(i));

            //--------------------------

            flightPojo.setPlane(plane);
            flightPojo.setPrice(plane.getSeats().get(0).getBasePrice());
            // this list is for the search result   listing all the flights
            flightPojos.add(flightPojo);
        }


        return flightPojos;
    }*/

    public void setFlightPojos(List<FlightPojo> flightPojos) {
        this.flightPojos = flightPojos;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }

    public String bookNow(long planeId){

        // TODO pass plane ID to booking page
        return "returnBooking?faces-redirect=true";
    }






}
