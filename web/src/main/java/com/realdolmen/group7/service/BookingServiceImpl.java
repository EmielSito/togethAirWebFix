package com.realdolmen.group7.service;

import com.realdolmen.group7.domain.payment.Payment;
import com.realdolmen.group7.domain.search.ClassType;
import com.realdolmen.group7.domain.search.Seat;
import com.realdolmen.group7.repository.BookingRepository;
import com.realdolmen.group7.repository.PaymentRepository;
import com.realdolmen.group7.repository.SeatRepository;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
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

    @Inject
    private PaymentRepository paymentRepository;

    @Override
    public void chooseSeatNumber(List<Seat> seats) {
        for (Seat s : seats) {
            s.setAvailable(false);
            seatRepository.updateSeat(s);
        }
    }

    public void savePayment(Payment payment) {
        paymentRepository.savePayment(payment);
    }

    public List<Seat> getAvailableSeatByPlane(String planeNumber, ClassType type, String departure, String destination,
                                              Date departureDate, int numberOfSeat) {
        return seatRepository.findAvailableSeatsByClassType(planeNumber, type);
    }

}