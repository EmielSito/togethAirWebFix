package com.realdolmen.group7.controller;


import com.realdolmen.group7.domain.search.ClassType;
import com.realdolmen.group7.domain.search.Seat;
import com.realdolmen.group7.service.BookingService;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class BookingController {

    @Inject
    private BookingService bookingService;

    public void chooseSeat(List<Seat> seats) {
        bookingService.chooseSeatNumber(seats);
    }
    public List<Seat> getAvailableSeatByClassType(String planeNumber, ClassType type, String departure, String destination,
                                                  Date departureDate, int numberOfSeat) {
        return bookingService.getAvailableSeatByPlane(planeNumber, type, departure, destination, departureDate, numberOfSeat);
    }
}