package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.payment.Payment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by PMTBF30 on 13/11/2017.
 */

public class PaymentRepository {
    @PersistenceContext
    EntityManager em;

    public void savePayment (Payment payment) {
        em.persist(payment);
    }

    public void updatePayment (Payment payment) {
        em.merge(payment);
    }

}
