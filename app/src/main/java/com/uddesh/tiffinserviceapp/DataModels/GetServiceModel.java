package com.uddesh.tiffinserviceapp.DataModels;

public class GetServiceModel {
    private final int id;
    private final String foodimage;
    private final String servicename;
    private final int price;
    private final String description;
    private final String upiid;

    public GetServiceModel(int id, String foodimage, String servicename, int price, String description, String upiid) {
        this.id = id;
        this.foodimage = foodimage;
        this.servicename = servicename;
        this.price = price;
        this.description = description;
        this.upiid = upiid;
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

    public String getDescription() {
        return description;
    }

    public String getUpiid() {
        return upiid;
    }
}
