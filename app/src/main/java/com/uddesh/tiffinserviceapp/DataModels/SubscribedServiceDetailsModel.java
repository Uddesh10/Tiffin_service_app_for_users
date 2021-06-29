package com.uddesh.tiffinserviceapp.DataModels;

public class SubscribedServiceDetailsModel {
    private final int id;
    private final String providername;
    private final String servicename;
    private final String servicedescription;
    private final int  daysremaining;
    private final String logoimage;
    private final String foodimage;
    private final boolean active;
    private final String upiid;

    public SubscribedServiceDetailsModel(int id, String providername, String servicename, String servicedescription, int daysremaining, String logoimage, String foodimage, boolean active, String upiid) {
        this.id = id;
        this.providername = providername;
        this.servicename = servicename;
        this.servicedescription = servicedescription;
        this.daysremaining = daysremaining;
        this.logoimage = logoimage;
        this.foodimage = foodimage;
        this.active = active;
        this.upiid = upiid;
    }

    public int getId() {
        return id;
    }

    public String getProvidername() {
        return providername;
    }

    public String getServicename() {
        return servicename;
    }

    public String getServicedescription() {
        return servicedescription;
    }

    public int getDaysremaining() {
        return daysremaining;
    }

    public String getLogoimage() {
        return logoimage;
    }

    public String getFoodimage() {
        return foodimage;
    }

    public boolean getActive() {
        return active;
    }

    public String getUpiid() {
        return upiid;
    }
}
