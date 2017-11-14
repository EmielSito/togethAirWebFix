package com.realdolmen.group7.beans;


import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Named
@SessionScoped
public class PlaneBean implements Serializable{
    private List<Plane> planeList = new ArrayList<>();

    public PlaneBean(){
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Locale locale = (Locale) session.getAttribute("locale");
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        planeList.add(new Plane("Rome",
                "Brussels",
                "Brussels Airlines",
                100.0,
                60.0,
                "Tuesday, 14/11/2017, 5:30",
                "Tuesday, 14/11/2017, 6:30",
                2));
        planeList.add(new Plane("Rome",
                "Brussels",
                "Brussels Airlines",
                115.0,
                75.0,
                "Tuesday, 14/11/2017, 7:00",
                "Tuesday, 14/11/2017, 8:00",
        3));
        planeList.add(new Plane("Rome",
                "Brussels",
                "Brussels Airlines",
                125.0,
                85.0,
                "Tuesday, 14/11/2017, 9:00",
                "Tuesday, 14/11/2017, 10:00",2));
        planeList.add(new Plane("Rome",
                "Brussels",
                "Brussels Airlines",
                125.0,
                85.0,
                "Tuesday, 14/11/2017, 13:00",
                "Tuesday, 14/11/2017, 14:00", 1));
        planeList.add(new Plane("Rome",
                "Brussels",
                "Brussels Airlines",
                115.0,
                75.0,
                "Tuesday, 14/11/2017, 19:00",
                "Tuesday, 14/11/2017, 20:00",4));
    }

    public List<Plane> getPlaneList() {
        return planeList;
    }

    public void setPlaneList(List<Plane> planeList) {
        this.planeList = planeList;
    }


}
