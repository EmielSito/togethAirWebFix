package com.realdolmen.group7.service;

import com.realdolmen.group7.domain.search.ClassType;
import com.realdolmen.group7.domain.search.Seat;

import java.util.List;

public interface BookingService {
    public int chooseSeatNumber(String seatNumber);

    public List<Seat> getAvailableSeatByClassType(ClassType type);
}
