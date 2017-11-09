package com.realdolmen.group7.service;



import com.realdolmen.group7.domain.search.ClassType;
import com.realdolmen.group7.domain.search.Seat;
import com.realdolmen.group7.repository.BookingRepository;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class BookingServiceImpl implements BookingService {


    @Inject
    private BookingRepository bookingRepository;


    @Override
    public int chooseSeatNumber(String seatNumber) {
        return bookingRepository.chooseBySeatNumber(seatNumber);
    }

    @Override
    public List<Seat> getAvailableSeatByClassType(ClassType type) {
        List<Seat>seatList=new ArrayList<>();
        List<Seat>seats=bookingRepository.availableSeat();

        for(Seat s:seats){
            if(s.getClassType().equals(type)){
                seatList.add(s);
            }
        }
        return seatList;
    }


}