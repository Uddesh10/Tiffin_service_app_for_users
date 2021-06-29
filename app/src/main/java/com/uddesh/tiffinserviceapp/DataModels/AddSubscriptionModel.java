package com.uddesh.tiffinserviceapp.DataModels;

public class AddSubscriptionModel {
    private final String username;
    private final int serviceid;
    private final int daysremaining;
    private final boolean active;

    public AddSubscriptionModel(String username, int serviceid, int daysremaining, boolean active) {
        this.username = username;
        this.serviceid = serviceid;
        this.daysremaining = daysremaining;
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public int getServiceid() {
        return serviceid;
    }

    public int getDaysremaining() {
        return daysremaining;
    }

    public boolean isActive() {
        return active;
    }
}
