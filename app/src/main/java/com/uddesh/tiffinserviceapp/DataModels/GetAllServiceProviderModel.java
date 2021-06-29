package com.uddesh.tiffinserviceapp.DataModels;

public class GetAllServiceProviderModel {
    private final String username;
    private final String providername;
    private final boolean vegnonveg;
    private final String logoimage;
    private final String availability;
    private final int startingprice;
    private final int distance;

    public GetAllServiceProviderModel(String username, String providername, boolean vegnonveg, String logoimage, String availability, int startingprice, int distance) {
        this.username = username;
        this.providername = providername;
        this.vegnonveg = vegnonveg;
        this.logoimage = logoimage;
        this.availability = availability;
        this.startingprice = startingprice;
        this.distance = distance;
    }

    public String getUsername() {
        return username;
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

    public int getStartingprice() {
        return startingprice;
    }

    public int getDistance() {
        return distance;
    }
}
