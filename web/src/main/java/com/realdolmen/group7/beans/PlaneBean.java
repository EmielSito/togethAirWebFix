package com.realdolmen.group7.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class PlaneBean implements Serializable{
    private List<Plane> planeList = new ArrayList<>();

    public PlaneBean(){
        planeList.add(new Plane("Rome",
                "Brussels",
                "Brussels Airlines",
                100.0,
                60.0,
                "Tuesday, 14/11/2017, 5:30",
                "Tuesday, 14/11/2017, 6:30"));
        planeList.add(new Plane("Rome",
                "Brussels",
                "Brussels Airlines",
                115.0,
                75.0,
                "Tuesday, 14/11/2017, 7:00",
                "Tuesday, 14/11/2017, 8:00"));
        planeList.add(new Plane("Rome",
                "Brussels",
                "Brussels Airlines",
                125.0,
                85.0,
                "Tuesday, 14/11/2017, 9:00",
                "Tuesday, 14/11/2017, 10:00"));
        planeList.add(new Plane("Rome",
                "Brussels",
                "Brussels Airlines",
                125.0,
                85.0,
                "Tuesday, 14/11/2017, 13:00",
                "Tuesday, 14/11/2017, 14:00"));
        planeList.add(new Plane("Rome",
                "Brussels",
                "Brussels Airlines",
                115.0,
                75.0,
                "Tuesday, 14/11/2017, 19:00",
                "Tuesday, 14/11/2017, 20:00"));
    }

    public List<Plane> getPlaneList() {
        return planeList;
    }

    public void setPlaneList(List<Plane> planeList) {
        this.planeList = planeList;
    }
}
