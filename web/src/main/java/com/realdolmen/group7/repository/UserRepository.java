package com.realdolmen.group7.repository;

import com.realdolmen.group7.domain.users.Person;
import com.realdolmen.group7.domain.users.User;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;

/**
 * Created by PMTBF30 on 8/11/2017.
 */
@Named
public class UserRepository implements Serializable{

    @PersistenceContext
    EntityManager em;

    @Transactional
    public User save(User user) {
        em.persist(user);
        return user;
    }

    public User findByEmail(String email) {
        return em.find(User.class, email);
    }
}
