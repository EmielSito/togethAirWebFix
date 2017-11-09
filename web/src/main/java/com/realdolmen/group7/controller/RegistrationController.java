package com.realdolmen.group7.controller;

import com.realdolmen.group7.domain.users.User;
import com.realdolmen.group7.repository.UserRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by ESOBG49 on 11/10/2017.
 */
@Named
@SessionScoped
public class RegistrationController implements Serializable {

    @Inject
    private UserRepository userRepository;

    private User user;

    public User getUser() {
        return user;
    }

 /*   public int getId(){
        return user.getId();
    }*/

    public String registerUser(){
        userRepository.save(user);
        this.user = new User();
        return "index?faces-redirect=true";
    }


}
