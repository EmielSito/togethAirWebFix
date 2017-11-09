package com.realdolmen.group7.domain.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by ESOBG49 on 6/11/2017.
 */
@Entity
public class Partner {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
