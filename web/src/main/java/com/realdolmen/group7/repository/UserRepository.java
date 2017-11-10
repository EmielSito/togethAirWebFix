package com.realdolmen.group7.repository;


import com.realdolmen.group7.domain.users.Person;
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
    private EntityManager entityManager;


    public User save(User user){
        entityManager.persist(user);
        return user;
    }



    public User findById(int id){
        return entityManager.find(User.class, id);
    }


    public List<User> findAll(){
        return entityManager.createQuery("select u FROM User u", User.class).getResultList();
    }

    public void remove(int userId){
        entityManager.remove(findById(userId));
    }

    public Person findByEmail(String email){
        return entityManager.find(Person.class, email);
    }


}
