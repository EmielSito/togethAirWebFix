package com.realdolmen.group7.service;


import com.realdolmen.group7.domain.search.ClassType;
import com.realdolmen.group7.domain.search.Plane;
import com.realdolmen.group7.domain.search.Seat;
import com.realdolmen.group7.repository.BookingRepository;
import com.realdolmen.group7.repository.SeatRepository;

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

    @Inject
    private SeatRepository seatRepository;

    private List<Seat> availableSeat = new ArrayList<>();

    @Override
    public void chooseSeatNumber(String seatNumber) {

        for (Seat s : availableSeat) {
            if (s.getSeatNumber().equals(seatNumber)) {
                s.setAvailable(false);
                seatRepository.updateSeat(s);
                break;
            }
        }
    }

    public List<Seat> getAvailableSeatByPlane(String planeNumber, ClassType type, String departure, String destination,
                                              Date departureDate, int numberOfSeat) {
        availableSeat = seatRepository.findAvailableSeatsByClassType(planeNumber, departure, destination, departureDate, type);
        return availableSeat;
    }

}