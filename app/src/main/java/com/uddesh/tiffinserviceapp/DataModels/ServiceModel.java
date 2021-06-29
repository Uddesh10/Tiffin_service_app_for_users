package com.uddesh.tiffinserviceapp.DataModels;

public class ServiceModel {
    private final int id;
    private final String foodimage;
    private final String servicename;
    private final int price;

    public ServiceModel(int id, String foodimage, String servicename, int price) {
        this.id = id;
        this.foodimage = foodimage;
        this.servicename = servicename;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getFoodimage() {
        return foodimage;
    }

    public String getServicename() {
        return servicename;
    }

    public int getPrice() {
        return price;
    }
}
