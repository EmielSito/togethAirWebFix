package com.realdolmen.group7.controller;

import com.realdolmen.group7.domain.booking.Ticket;
import com.realdolmen.group7.domain.payment.Payment;
import com.realdolmen.group7.domain.search.ClassType;
import com.realdolmen.group7.domain.search.Seat;
import com.realdolmen.group7.service.BookingServiceImpl;
import com.realdolmen.group7.service.pojo.AccountNumber;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class BookingController implements Serializable{


    @Inject
    private BookingServiceImpl bookingService;
    private Ticket ticket = new Ticket();
    private Payment payment=new Payment();
    private AccountNumber accountNumber=new AccountNumber();


    public AccountNumber getAccountNumber() {
        return accountNumber;
    }
    public void getPaymentMethod() {
         bookingService.getPaymentMethod();
    }

    public Payment getPayment() {
        return payment;
    }


    public Ticket getTicket() {
        return ticket;
    }

    public void chooseSeat(List<Seat> seats) {
        bookingService.chooseSeatNumber(seats);
    }

    public List<Seat> getAvailableSeatByClassType(String planeNumber, ClassType type, String departure, String destination,
                                                  Date departureDate, int numberOfSeat) {
        return bookingService.getAvailableSeatByPlane(planeNumber, type, departure, destination, departureDate, numberOfSeat);
    }
}