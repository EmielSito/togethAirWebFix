package com.realdolmen.group7.service;


import com.realdolmen.group7.domain.search.ClassType;
import com.realdolmen.group7.domain.search.Plane;
import com.realdolmen.group7.domain.search.Seat;
import com.realdolmen.group7.repository.BookingRepository;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class BookingServiceImpl implements BookingService {


    @Inject
    private BookingRepository bookingRepository;

    @Inject
    private SearchServiceImpl searchService;

    private List<Seat> seatAvailable;

    @Override
    public void chooseSeatNumber(String seatNumber) {
        for (Seat s : seatAvailable) {
            if (s.getSeatNumber().equals(seatNumber)) {
                s.setAvailable(false);
                bookingRepository.chooseBySeatNumber(s);

            }
        }
    }


    public List<Seat> getAvailableSeatByPlane(String planeNumber, ClassType type, String departure, String destination,
                                              Date departureDate, int numberOfSeat) {

        List<Seat> seatList = new ArrayList<>();
        List<Plane> planes = searchService.findPlaneByAvailableSeat(type, departure, destination, departureDate, numberOfSeat);
        seatAvailable = new ArrayList<>();
        for (Plane p : planes) {
            if (p.getPlaneNumber().equals(planeNumber)) {
                seatList = p.getSeats();
            }
        }
        for (Seat s : seatList) {
            if (s.isAvailable() == true && s.getClassType().equals(type)) {
                seatAvailable.add(s);
            }
        }

        return seatAvailable;

    }

}