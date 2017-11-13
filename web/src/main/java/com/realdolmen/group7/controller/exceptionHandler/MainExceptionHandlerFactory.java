package com.realdolmen.group7.controller.exceptionHandler;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 * Created by ESOBG49 on 10/11/2017.
 */
public class MainExceptionHandlerFactory extends ExceptionHandlerFactory {

    private ExceptionHandlerFactory parent;

    public MainExceptionHandlerFactory(ExceptionHandlerFactory parent) {
        this.parent = parent;
    }

    @Override
    public ExceptionHandler getExceptionHandler() {
        ExceptionHandler result = new MainExceptionHandler(parent.getExceptionHandler());
        return result;
    }
}