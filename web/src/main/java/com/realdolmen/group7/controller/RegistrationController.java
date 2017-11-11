package com.realdolmen.group7.controller;

import com.realdolmen.group7.domain.users.Person;
import com.realdolmen.group7.domain.users.User;
import com.realdolmen.group7.service.RegistrationService;


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
    RegistrationService registrationService;

    private User user = new User();

    public Person getUser() {
        return user;
    }

    public String savePerson() {
        registrationService.save(user);
        //go back to the last page
        return "oneWayBooking?faces-redirect=true";
    }

    public String login(String email, String password) {
        Person user = registrationService.findByEmail(email);
        if (!user.getPassword().equals(password)) {
            return "login?faces-redirect=true";
        }
        //go back to the last page
        return "booking?faces-redirect=true";
    }


}
