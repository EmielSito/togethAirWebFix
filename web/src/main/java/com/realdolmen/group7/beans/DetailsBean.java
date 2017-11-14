package com.realdolmen.group7.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named
@SessionScoped
public class DetailsBean implements Serializable{

    private Plane selectedPlane;
    private Booking booking;;
    private List<Seat> tempSeats = new ArrayList<>();
    private String tempNewSeat;
    private Ticket tempTicket;
    private double totalReducedPrice = 0.0, totalOriginalPrice = 0.0;
    private List<String> paymentMethods = new ArrayList<>();
    private String paymentMethod = "Credit Card";
    private boolean showable = true;

    public Plane getSelectedPlane() {
        return selectedPlane;
    }

    public void setSelectedPlane(Plane selectedPlane) {
        this.selectedPlane = selectedPlane;
        createBooking();
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public List<Seat> getTempSeats() {
        return tempSeats;
    }

    public void setTempSeats(List<Seat> tempSeats) {
        this.tempSeats = tempSeats;
    }

    public String getTempNewSeat() {
        return tempNewSeat;
    }

    public void setTempNewSeat(String tempNewSeat) {
        this.tempNewSeat = tempNewSeat;
    }

    public double getTotalReducedPrice() {
        return totalReducedPrice;
    }

    public void setTotalReducedPrice(double totalReducedPrice) {
        this.totalReducedPrice = totalReducedPrice;
    }

    public double getTotalOriginalPrice() {
        return totalOriginalPrice;
    }

    public void setTotalOriginalPrice(double totalOriginalPrice) {
        this.totalOriginalPrice = totalOriginalPrice;
    }

    public Ticket getTempTicket() {
        return tempTicket;
    }

    public void setTempTicket(Ticket tempTicket) {
        this.tempTicket = tempTicket;
    }

    public List<String> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<String> paymentMethods) {
        this.paymentMethods = paymentMethods;
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

    public void onSeatChange(AjaxBehaviorEvent event){

        Seat newSeat = selectedPlane.getAvailableSeats().get(tempNewSeat);

        tempSeats.remove(newSeat);
        tempSeats.add(tempTicket.getSeat());

        totalReducedPrice -= tempTicket.getSeat().getReducedPrice();
        totalOriginalPrice -= tempTicket.getSeat().getOriginalPrice();
        tempTicket.setSeat(newSeat);
        totalReducedPrice += tempTicket.getSeat().getReducedPrice();
        totalOriginalPrice += tempTicket.getSeat().getOriginalPrice();

    }

    public void onPaymentChange(AjaxBehaviorEvent event){
        if(paymentMethod.equals("Credit Card")){
            this.setShowable(true);
        }

        else{
            this.setShowable(false);
        }
    }

    private void createBooking(){
        booking = new Booking();
        Set<String> keys = selectedPlane.getAvailableSeats().keySet();
        for(String key : keys){
            tempSeats.add(selectedPlane.getAvailableSeats().get(key));
        }
        for(int i = 0; i < selectedPlane.getNumberOfPassengers(); i++){
            Ticket newTicket = new Ticket();
            Seat seat = tempSeats.remove(0);
            newTicket.setSeat(seat);
            booking.addTicket(newTicket);
            totalOriginalPrice += seat.getOriginalPrice();
            totalReducedPrice += seat.getReducedPrice();
        }
    }

    @PostConstruct
    public void init(){
        paymentMethods.add("Credit Card");
        paymentMethods.add("Endorsement");
    }
}
