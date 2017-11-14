package com.realdolmen.group7.service;

import com.realdolmen.group7.domain.search.ClassType;
import com.realdolmen.group7.domain.search.Plane;
import com.realdolmen.group7.domain.search.Seat;

import java.util.Date;
import java.util.List;


public interface BookingService {

    void chooseSeatNumber(List<Seat> seats);
    public List<Seat> getAvailableSeatByPlane(String planeNumber, ClassType type);

    //public Plane getPlaneInResultSearch(String planeNumber);
    public void getPaymentMethod();

}
