package com.realdolmen.group7.controller;

import com.realdolmen.group7.domain.booking.Booking;
import com.realdolmen.group7.domain.booking.Ticket;
import com.realdolmen.group7.domain.payment.Payment;
import com.realdolmen.group7.domain.payment.PaymentMethod;
import com.realdolmen.group7.domain.search.Flight;
import com.realdolmen.group7.domain.search.Plane;
import com.realdolmen.group7.domain.search.Seat;
import com.realdolmen.group7.service.BookingServiceImpl;
import com.realdolmen.group7.service.TicketService;
import com.realdolmen.group7.service.pojo.SeatAvailable;
import com.realdolmen.group7.util.DateUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class BookingController implements Serializable {


    @Inject
    private BookingServiceImpl bookingService;
    @Inject
    private TicketService ticketService;
    @Inject
    private SearchResultController searchResultController;
    @Inject
    private SearchController searchController;

    private List<Seat> seats = new ArrayList<>();

    private String firstName;
    private String lastName;

    private SeatAvailable seat;
    private boolean showable = true;
    private String paymentMethod = "CREDITCARD";
    private String accountNumber;
    private Date expiryDate;
    private String seatNumber;
    private Payment payment = new Payment();
    private Plane selectedPlane;
    private List<Ticket> tickets = new ArrayList<>();
    private int numberOfPassengers;
    private Ticket tempTicket;

    @PostConstruct
    public void init() {
        selectedPlane = searchResultController.getPlane();
        seats = bookingService.getAvailableSeatByPlane(selectedPlane.getPlaneNumber(), searchController.getClassType());
        numberOfPassengers = searchController.getNumberOfSeats();
        this.initTickets();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SearchResultController getSearchResultController() {
        return searchResultController;
    }

    public void setSearchResultController(SearchResultController searchResultController) {
        this.searchResultController = searchResultController;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }


    public SeatAvailable getSeat() {
        return seat;
    }

    public void setSeat(SeatAvailable seat) {
        this.seat = seat;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    public boolean isShowable() {
        return showable;
    }

    public void setShowable(boolean showable) {
        this.showable = showable;
    }

    public Payment getPayment() {
        return payment;
    }

    public Plane getSelectedPlane() {
        return selectedPlane;
    }

    public void setSelectedPlane(Plane selectedPlane) {
        this.selectedPlane = selectedPlane;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public Ticket getTempTicket() {
        return tempTicket;
    }

    public void setTempTicket(Ticket tempTicket) {
        this.tempTicket = tempTicket;
    }

    public void show(AjaxBehaviorEvent event) {

        if (paymentMethod.equals("CREDITCARD")) {

            this.payment.setPaymentMethod(PaymentMethod.CREDITCARD);
            setShowable(true);
        } else {
            this.payment.setPaymentMethod(PaymentMethod.ENDORSEMENT);
            setShowable(false);
        }
    }

    @Transactional
    public String confirmBooking() {

        for(Ticket ticket : getTickets()){
            System.out.println(ticket.getFirstName() + ticket.getLastName() + ticket.getSeat().getSeatNumber());
        }
        /*Seat seat = new Seat();

        List<Seat> tempSeats = new ArrayList<>();
        tempSeats = seats;


        bookingService.chooseSeatNumber(tempSeats.get(0));


        List<Flight> flights = new ArrayList<>();
        List<Ticket> tickets = new ArrayList<>();

        Booking booking = new Booking();
        Plane plane = searchResultController.getPlane();
        flights.add(plane.getFlight());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date datum = new Date();
        booking.setBookingDate(DateUtils.createDate(dateFormat.format(datum)));
        booking.setFlights(flights);

        //Payment payment = new Payment();
        payment.setPaid(true);

        booking.setPayment(payment);
        //booking.setUser();
        bookingService.savePayment(payment);
        Ticket ticket = new Ticket();
        ticket.setLastName(lastName);
        ticket.setFirstName(firstName);
        ticket.setPlane(searchResultController.getPlane());
        ticket.setBooking(booking);
        tickets.add(ticket);

        booking.setTickets(tickets);
        bookingService.saveBooking(booking);
        bookingService.saveTicket(ticket);

        ticket.setSeat(tempSeats.get(0));
        bookingService.updatePayment(payment);
        bookingService.updateTicket(ticket);
        return "thank?faces-redirect=true";*/

        return "p-single.xhtml";
    }

    public double getTotalPrice(){
        double result = 0.0;
        for(Ticket ticket : tickets){
            result += ticket.getSeat().getBasePrice();
        }

        return result;


    }

    public List<PaymentMethod> getPaymentMethods(){
        return Arrays.asList(PaymentMethod.values());
    }

    public void initTicket(Ticket ticket){
        System.out.println(firstName);
        System.out.println(ticket.getSeat().getSeatNumber());
    }

    private void initTickets() {
        for(int i=0; i < numberOfPassengers; i++){
            Ticket newTicket = new Ticket();
            newTicket.setSeat(seats.remove(0));
            newTicket.setPlane(selectedPlane);
            tickets.add(newTicket);
        }
    }


}