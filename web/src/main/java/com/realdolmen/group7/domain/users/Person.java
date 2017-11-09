package com.realdolmen.group7.domain.users;

/**
 * Created by ESOBG49 on 7/11/2017.
 */
public abstract class Person {


    private String email;

    private String password;


    public Person() {
    }

    public Person(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void signup() {

    }

}
