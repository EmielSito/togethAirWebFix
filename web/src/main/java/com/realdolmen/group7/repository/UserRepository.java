package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.users.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Created by PMTBF30 on 8/11/2017.
 */
public class UserRepository implements Serializable{

    @PersistenceContext
    EntityManager em;

    public Person save(Person user) {
        em.persist(user);
        return user;
    }

    public Person findByEmail(String email) {
        return em.find(Person.class, email);
    }
}
