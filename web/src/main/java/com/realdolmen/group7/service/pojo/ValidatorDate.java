package com.realdolmen.group7.service.pojo;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@FacesValidator("ValidatorDate")
public class ValidatorDate implements Validator {

    private AccountNumber accountNumber;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {


        try {
            if () {
                throw new ValidatorException(new FacesMessage("A valid date"));
            } else {
                throw new ValidatorException(new FacesMessage("date dont figure in the database"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateDate(Date date) {

        String date1="dd/MM/yyyy";
                DateFormat formatter = new SimpleDateFormat();


        formatter.setCalendar(Calendar.getInstance());

        try {
            date = formatter.parse(formatter.format(date));
            date = formatter.parse("dd/MM/yyyy");

        } catch (ParseException e) {
            e.printStackTrace();
        }





    }

}
