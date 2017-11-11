package com.realdolmen.group7.service;

import com.realdolmen.group7.domain.search.ClassType;
import com.realdolmen.group7.domain.search.Seat;

import java.util.Date;
import java.util.List;

public interface BookingService {

    void chooseSeatNumber(List<Seat> seats);

    List<Seat> getAvailableSeatByPlane(String planeNumber, ClassType type,
                                       String departure, String destination,
                                       Date departureDate, int numberOfSeat);


}
