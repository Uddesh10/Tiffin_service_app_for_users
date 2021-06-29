package com.uddesh.tiffinserviceapp.DataModels;

public class SignupModel {
    private final String username;
    private final String fullname;
    private final String password;
    private final String mobileno;

    public SignupModel(String username, String fullname, String password, String mobileno) {
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.mobileno = mobileno;
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPassword() {
        return password;
    }

    public String getMobileno() {
        return mobileno;
    }
}
