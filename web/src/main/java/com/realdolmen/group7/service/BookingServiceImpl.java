package com.realdolmen.group7.service;


import com.realdolmen.group7.domain.booking.Booking;

import com.realdolmen.group7.domain.search.ClassType;
import com.realdolmen.group7.domain.search.Seat;
import com.realdolmen.group7.repository.BookingRepository;
import com.realdolmen.group7.repository.SeatRepository;
import com.realdolmen.group7.service.pojo.BookingPojo;


import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.ManyToMany;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class BookingServiceImpl implements BookingService, Serializable {


    @Inject
    private BookingRepository bookingRepository;

    @Inject
    private SearchServiceImpl searchService;

    @Inject
    private SeatRepository seatRepository;

    @Override
    public void chooseSeatNumber(List<Seat> seats) {

        for (Seat s : seats) {
            s.setAvailable(false);
            seatRepository.updateSeat(s);
        }
    }

    public List<Seat> getAvailableSeatByPlane(String planeNumber, ClassType type, int numberOfSeat) {
        return seatRepository.findAvailableSeatsByClassType(planeNumber, type);
    }

    @Override
    public List<BookingPojo> getJaXBBookingByDay(Date date) {


        List<Booking> bookingList = bookingRepository.findBookingByDay(date);

        List<BookingPojo> bookingPojos=new ArrayList<>();

        for(Booking b:bookingList){
            BookingPojo bookingPojo=new BookingPojo();
            bookingPojo.setBookingdate(b.getBookingDate());

            bookingPojos.add(bookingPojo);
        }




        try {
            File file = new File("src/main/resources/META-INF/file.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(BookingPojo.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.marshal(bookingList, file);

        } catch (JAXBException e) {
            e.printStackTrace();

        }
        return bookingPojos;
    }


}





