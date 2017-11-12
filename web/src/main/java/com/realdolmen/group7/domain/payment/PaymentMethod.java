package com.realdolmen.group7.domain.payment;

/**
 * Created by ESOBG49 on 6/11/2017.
 */
public enum PaymentMethod {
    CREDITCARD("CreditCard"),
    ENDORSEMENT("Endorsement");

    public String getPaymentMethod() {
        return paymentMethod;
    }

    private final String paymentMethod;


    private PaymentMethod(final String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return paymentMethod;
    }
}
