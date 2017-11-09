package com.realdolmen.group7.controller;


import com.realdolmen.group7.domain.search.ClassType;
import com.realdolmen.group7.domain.search.Seat;
import com.realdolmen.group7.service.BookingService;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@SessionScoped
public class BookingController {

    @Inject
    private BookingService bookingService;

    public int chooseSeat(String seatNumber) {
        return bookingService.chooseSeatNumber(seatNumber);

    }

    public List<Seat> getAvailableSeatByClassType(ClassType type) {
        return bookingService.getAvailableSeatByClassType(type);
    }
}