package com.realdolmen.group7.repository;


import com.realdolmen.group7.domain.users.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ESOBG49 on 7/11/2017.
 */
public class UserRepository implements Serializable {

    @PersistenceContext
    private EntityManager em;


    public User save(User user) {
        em.persist(user);
        return user;
    }

    public User findById(int id) {
        return em.find(User.class, id);
    }

    public User findByEmail(String email) {

        return em.createQuery("select u from User u where u.email like :args", User.class).setParameter("args", email).getSingleResult();
    }

    public List<User> findAll() {
        return em.createQuery("select u FROM User u", User.class).getResultList();
    }

    public void remove(int userId) {
        em.remove(findById(userId));
    }
}
