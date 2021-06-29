package com.uddesh.tiffinserviceapp.DataModels;

public class SubscribedServiceModel {

    private final int id;
    private final String providername;
    private final String servicename;
    private final String logoimage;
    private final boolean active;

    public SubscribedServiceModel(int id, String providername, String servicename, String logoimage, boolean active) {
        this.id = id;
        this.providername = providername;
        this.servicename = servicename;
        this.logoimage = logoimage;
        this.active = active;
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

    public String getLogoimage() {
        return logoimage;
    }

    public boolean isActive() {
        return active;
    }
}
