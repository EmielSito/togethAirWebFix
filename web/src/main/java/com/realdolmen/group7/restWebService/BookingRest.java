package com.realdolmen.group7.restWebService;


import com.realdolmen.group7.service.BookingService;
import com.realdolmen.group7.service.pojo.BookingPojo;
import com.realdolmen.group7.util.DateUtils;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;



@Path("/booking")
public class BookingRest {

    @Inject
    BookingService bookingService;

    @GET
    @Path("{date}")
    @Produces(MediaType.APPLICATION_XML)
    public List<BookingPojo> readBookindDay(@PathParam("date") String date) {

        return bookingService.getJaXBBookingByDay(DateUtils.createDate(date));

    }
}
