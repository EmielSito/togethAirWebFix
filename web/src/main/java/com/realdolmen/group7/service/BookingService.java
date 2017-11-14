package com.realdolmen.group7.service;

import com.realdolmen.group7.domain.booking.Booking;
import com.realdolmen.group7.domain.search.ClassType;
import com.realdolmen.group7.domain.search.Plane;
import com.realdolmen.group7.domain.search.Seat;
import com.realdolmen.group7.service.pojo.BookingPojo;

import java.util.Date;
import java.util.List;


public interface BookingService {

    public void chooseSeatNumber(List<Seat> seats);
    public List<Seat> getAvailableSeatByPlane(String planeNumber, ClassType type, int numberOfSeat);

    public List<Seat> getAvailableSeatByPlane(String planeNumber, ClassType type);

    public List<BookingPojo> getJaXBBookingByDay(Date date);

}
