package com.realdolmen.group7.controller.exceptionHandler;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import java.util.Iterator;

/**
 * Created by ESOBG49 on 10/11/2017.
 */
public class MainExceptionHandler extends ExceptionHandlerWrapper {
    private ExceptionHandler wrapped;


    public MainExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;
    }

    @Override
    public void handle() throws FacesException {
        Iterator iterator = getUnhandledExceptionQueuedEvents().iterator();

        while (iterator.hasNext()) {
            ExceptionQueuedEvent event = (ExceptionQueuedEvent) iterator.next();
            ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();

            Throwable throwable = context.getException();

            FacesContext fc = FacesContext.getCurrentInstance();

            try {
                Flash flash = fc.getExternalContext().getFlash();


                flash.put("errorDetails", throwable.getMessage());  // can be displayed in the error page if needed

                System.out.println("An error occurred: " + throwable.getMessage());

                NavigationHandler navigationHandler = fc.getApplication().getNavigationHandler();

                navigationHandler.handleNavigation(fc, null, "error?faces-redirect=true");

                fc.renderResponse();
            } finally {
                iterator.remove();
            }
        }

        // Let the parent handle the rest
        getWrapped().handle();
    }
}
