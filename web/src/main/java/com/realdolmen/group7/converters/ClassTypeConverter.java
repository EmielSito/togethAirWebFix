package com.realdolmen.group7.converters;

import com.realdolmen.group7.domain.search.ClassType;

import javax.faces.convert.EnumConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "classTypeConverter")
public class ClassTypeConverter extends EnumConverter{

    public ClassTypeConverter() {
        super(ClassType.class);
    }
}
