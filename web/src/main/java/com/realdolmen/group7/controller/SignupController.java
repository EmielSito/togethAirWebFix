package com.realdolmen.group7.controller;

import com.realdolmen.group7.domain.users.Person;
import com.realdolmen.group7.domain.users.User;
import com.realdolmen.group7.service.UserServiceBean;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by PMTBF30 on 8/11/2017.
 */
@Named
@SessionScoped
public class SignupController {

    @Inject
    UserServiceBean userServiceBean;

    private Person user = new User();

    public Person getUser() {
        return user;
    }

    public String savePerson() {
        userServiceBean.save(user);
        return "registration?faces-redirect=true";
    }
}
