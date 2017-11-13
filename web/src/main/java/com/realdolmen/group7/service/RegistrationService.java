package com.realdolmen.group7.service;

import com.realdolmen.group7.domain.users.Person;
import com.realdolmen.group7.domain.users.User;
import com.realdolmen.group7.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Created by ESOBG49 on 7/11/2017.
 */


@ApplicationScoped
public class RegistrationService {

    @Inject
    UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }

}
