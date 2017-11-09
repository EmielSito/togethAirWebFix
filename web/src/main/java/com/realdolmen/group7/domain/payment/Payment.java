package com.realdolmen.group7.domain.payment;


import javax.persistence.*;

/**
 * Created by ESOBG49 on 6/11/2017.
 */

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private boolean isPaid;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }




}
