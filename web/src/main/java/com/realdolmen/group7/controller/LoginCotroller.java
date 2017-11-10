package com.realdolmen.group7.controller;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by PMTBF30 on 8/11/2017.
 */
@Named
@SessionScoped
public class LoginCotroller {

    @Inject
    UserServiceBean userServiceBean;



    public void findByEmail(String email, String password) {
        userServiceBean.findByEmail(email, password);
    }
}
