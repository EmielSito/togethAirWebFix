package com.realdolmen.group7.service;

import com.realdolmen.group7.domain.users.Person;
import com.realdolmen.group7.domain.users.User;
import com.realdolmen.group7.repository.UserRepository;

import javax.inject.Inject;

/**
 * Created by PMTBF30 on 8/11/2017.
 */

public class UserServiceBean {

    @Inject
    UserRepository personRepository;

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Person findByEmail(String email, String password) {
        User user = (User) personRepository.findByEmail(email);
        //if (password != user.getPassword())
            //return Exception;

            return user;
    }
}
