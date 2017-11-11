package com.realdolmen.group7.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;

@ManagedBean
@SessionScoped
public class CalendarBean {
    private Date date = new Date();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
