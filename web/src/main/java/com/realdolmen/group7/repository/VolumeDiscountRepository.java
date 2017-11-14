package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.payment.VolumeDiscount;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public class VolumeDiscountRepository implements Serializable {

    @PersistenceContext
    EntityManager entityManager;


    public List<VolumeDiscount> findVolumeDiscountByPlane(String planeNumber){
        return entityManager.createQuery("select vd from Plane p  join p.discount vd  where p.planeNumber=:args ",VolumeDiscount.class)
                .setParameter("args",planeNumber).getResultList();
    }
}
