package com.realdolmen.group7.validation;


import com.realdolmen.group7.service.pojo.AccountNumber;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.validation.constraints.NotNull;
import java.util.Date;


@FacesValidator("ValidatorDate")
public class ValidatorDate implements Validator {

    @NotNull
    private AccountNumber accountNumber;


    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        try {
            if (compareDate(new Date(), accountNumber.getExpirydate()) == 0 ) {
                throw new ValidatorException(new FacesMessage(" Valid  date "));
            } else {
                throw new ValidatorException(new FacesMessage(" No valid date "));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static int compareDate(Date date, Date expireDate) {
        if (date.getYear() <= expireDate.getYear() &&
                date.getMonth() <= expireDate.getMonth() &&
                date.getDate() <= expireDate.getDate()) {
            return 0;
        } else if (date.getYear() > date.getYear()) {
            return -1;
        } else {
            return 1;
        }
    }

}


