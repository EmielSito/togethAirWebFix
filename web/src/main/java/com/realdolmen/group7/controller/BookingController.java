package com.realdolmen.group7.controller;

import com.realdolmen.group7.domain.booking.Ticket;
import com.realdolmen.group7.domain.payment.Payment;
import com.realdolmen.group7.domain.payment.PaymentMethod;
import com.realdolmen.group7.domain.search.ClassType;

import com.realdolmen.group7.domain.search.Seat;
import com.realdolmen.group7.service.BookingService;
import com.realdolmen.group7.service.TicketService;

import com.realdolmen.group7.service.pojo.SeatAvailable;


import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class BookingController implements Serializable{


    @Inject
    private BookingService bookingService;
    @Inject
    private TicketService ticketService;

    public SearchResultController getSearchResultController() {
        return searchResultController;
    }

    public void setSearchResultController(SearchResultController searchResultController) {
        this.searchResultController = searchResultController;
    }

    @Inject
    private SearchResultController searchResultController;

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private Ticket ticket ;
    private Payment payment;
    private SeatAvailable seat;
    private boolean showable=false;
    private String paymentMethod="";
    private String accountNumber;
    private Date expiryDate;

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


    public void show(AjaxBehaviorEvent event){

        if(paymentMethod.equals("creditCard")){

            this.payment.setPaymentMethod(PaymentMethod.CREDITCARD);
            setShowable(true);
        }
        else {
            this.payment.setPaymentMethod(PaymentMethod.ENDORSEMENT);
            setShowable(false);
        }
    }

    public void changeValue(ValueChangeEvent event) {

        if(event.getNewValue().equals(PaymentMethod.CREDITCARD)){
            setShowable(true);

        }else if( event.getNewValue().equals(PaymentMethod.ENDORSEMENT));
        setShowable(false);
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void chooseSeat(List<Seat> seats) {
        bookingService.chooseSeatNumber(seats);
    }

    public List<Seat> getAvailableSeatByClassType(String planeNumber, ClassType type,int numberOfSeat) {
        return bookingService.getAvailableSeatByPlane(planeNumber, type, numberOfSeat);

    }

    public Ticket saveTicket(){
        return ticketService.save(ticket);
    }

    public PaymentMethod[] listPaymentMethod(){

        return PaymentMethod.values();
    }


}