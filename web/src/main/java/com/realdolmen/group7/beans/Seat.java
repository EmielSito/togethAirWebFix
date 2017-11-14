package com.realdolmen.group7.beans;

public class Seat {

    private String seatNumber, seatClass;
    private double reducedPrice, originalPrice;

    public Seat() {
    }

    public Seat(String seatNumber, String seatClass) {
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;

        if(seatClass.equals("Business")){
            this.reducedPrice = 80.0;
            this.originalPrice = 100.0;
        }

        else if(seatClass.equals("First Class")){
            this.reducedPrice = 90.0;
            this.originalPrice = 110.0;
        }

        else{
            this.reducedPrice = 70.0;
            this.originalPrice = 90.0;
        }
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public double getReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(double reducedPrice) {
        this.reducedPrice = reducedPrice;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        if (!seatNumber.equals(seat.seatNumber)) return false;
        return seatClass.equals(seat.seatClass);
    }

    @Override
    public int hashCode() {
        int result = seatNumber.hashCode();
        result = 31 * result + seatClass.hashCode();
        return result;
    }
}
