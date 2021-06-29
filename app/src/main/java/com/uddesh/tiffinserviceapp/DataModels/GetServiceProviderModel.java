package com.uddesh.tiffinserviceapp.DataModels;

import java.util.List;

public class GetServiceProviderModel {
    private final String providername;
    private final boolean vegnonveg;
    private final String logoimage;
    private final String availability;
    private final int distance;
    private final String lunchtimings;
    private final String dinnertimings;
    private final String contactno;
    private final List<ServiceModel> services;

    public GetServiceProviderModel(String providername, boolean vegnonveg, String logoimage, String availability, int distance, String lunchtimings, String dinnertimings, String contactno, List<ServiceModel> services) {
        this.providername = providername;
        this.vegnonveg = vegnonveg;
        this.logoimage = logoimage;
        this.availability = availability;
        this.distance = distance;
        this.lunchtimings = lunchtimings;
        this.dinnertimings = dinnertimings;
        this.contactno = contactno;
        this.services = services;
    }

    public String getProvidername() {
        return providername;
    }

    public boolean isVegnonveg() {
        return vegnonveg;
    }

    public String getLogoimage() {
        return logoimage;
    }

    public String getAvailability() {
        return availability;
    }

    public int getDistance() {
        return distance;
    }

    public String getLunchtimings() {
        return lunchtimings;
    }

    public String getDinnertimings() {
        return dinnertimings;
    }

    public String getContactno() {
        return contactno;
    }

    public List<ServiceModel> getServices() {
        return services;
    }
}
