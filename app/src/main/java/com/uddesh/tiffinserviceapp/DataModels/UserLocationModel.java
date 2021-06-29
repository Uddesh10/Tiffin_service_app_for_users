package com.uddesh.tiffinserviceapp.DataModels;

public class UserLocationModel {
    private final String location;
    private final double latitude;
    private final double longitude;
    private final String username;

    public UserLocationModel(String location, double latitude, double longitude, String username) {
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getUsername() {
        return username;
    }
}
