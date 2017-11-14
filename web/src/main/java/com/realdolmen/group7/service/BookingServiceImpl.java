package com.realdolmen.group7.service;


import com.realdolmen.group7.domain.booking.Booking;
import com.realdolmen.group7.domain.booking.Ticket;
import com.realdolmen.group7.domain.payment.Payment;
import com.realdolmen.group7.domain.search.ClassType;
import com.realdolmen.group7.domain.search.Seat;
import com.realdolmen.group7.repository.BookingRepository;
import com.realdolmen.group7.repository.PaymentRepository;
import com.realdolmen.group7.repository.SeatRepository;
import com.realdolmen.group7.repository.TicketRepository;
import com.realdolmen.group7.service.pojo.BookingPojo;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class BookingServiceImpl implements Serializable {


    @Inject
    private BookingRepository bookingRepository;

    @Inject
    private SearchServiceImpl searchService;

    @Inject
    private SeatRepository seatRepository;

    @Inject
    private TicketRepository ticketRepository;

    @Inject
    private PaymentRepository paymentRepository;


    public void chooseSeatNumber(Seat seat) {

            seat.setAvailable(false);
            seatRepository.updateSeat(seat);

    }

    public void savePayment(Payment payment) {
        paymentRepository.savePayment(payment);

    }

    public void updatePayment(Payment payment) {
        paymentRepository.updatePayment(payment);

    }

    public void saveBooking(Booking booking) {
        bookingRepository.save(booking);

    }

    public void updateTicket(Ticket ticket) {
        ticketRepository.update(ticket);
    }

    public List<Seat> getAvailableSeatByPlane(String planeNumber, ClassType type) {
        return seatRepository.findAvailableSeatsByClassType(planeNumber, type);
    }



   public void saveTicket(Ticket ticket) {
        ticketRepository.save(ticket);
   }


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





