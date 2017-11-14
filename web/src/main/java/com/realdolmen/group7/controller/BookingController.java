package com.realdolmen.group7.controller;

import com.realdolmen.group7.domain.payment.Payment;
import com.realdolmen.group7.domain.search.ClassType;
import com.realdolmen.group7.domain.search.Seat;
import com.realdolmen.group7.service.BookingService;
import com.realdolmen.group7.service.pojo.AccountNumber;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


import java.util.List;

import static com.realdolmen.group7.util.AppStartupConfig.bic;
import static com.realdolmen.group7.util.AppStartupConfig.iban;

@Named
@SessionScoped
public class BookingController{

    @Inject
    private BookingService bookingService;
    private String firsName;
    private String lastName;
    private String expDate;

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


    public void chooseSeat(List<Seat> seats) {
        bookingService.chooseSeatNumber(seats);
    }

    public List<Seat> getAvailableSeatByClassType(String planeNumber, ClassType type) {
        return bookingService.getAvailableSeatByPlane(planeNumber, type);
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public void setAccountNumber(AccountNumber accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIban() {
        return iban;
    }

    public String getBic() {
        return bic;
    }

    public void makeBooking() {
        if(accountNumber.equals(null) && expDate.equals(null)) {

        }
    }
}