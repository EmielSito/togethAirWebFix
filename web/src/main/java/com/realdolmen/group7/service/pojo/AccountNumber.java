package com.realdolmen.group7.service.pojo;

import java.io.Serializable;
import java.util.Date;

public class AccountNumber implements Serializable{

    private String prefix;
    private String number;
    private String postfix;

    private Date expiredate;

    public Date getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(Date expiredate) {
        this.expiredate = expiredate;
    }

    private static final long serialVersionUID = 1L;


    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

        public String getPostfix() {
            return postfix;
        }

    public void setPostfix(String postfix) {
        this.postfix = postfix;
    }


    @Override
    public String toString() {
        return prefix+number+postfix;
    }





}
