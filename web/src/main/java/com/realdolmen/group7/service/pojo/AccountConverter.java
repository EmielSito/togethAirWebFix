package com.realdolmen.group7.service.pojo;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


@FacesConverter(forClass=AccountNumber.class,value = "AccountConverter")
public class AccountConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value==null || value.trim().equals("")) {
            return null;
        }

        if(value.length()!=12) {
            FacesMessage message=new FacesMessage("error");
            throw new ConverterException(message);
        }
        AccountNumber number=new AccountNumber();
        String []account=value
                .split("/");
        if(account.length==3) {
            number.setPrefix(account[0]);
            number.setNumber(account[1]);
            number.setPostfix(account[2]);
        }
        return number;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }



}