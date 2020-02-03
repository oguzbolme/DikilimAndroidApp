package com.ozibolme.dikilim.Classes;

public class Taxi {

    private String name;
    private String telNumber,latitude,longitude;
    private String imageUrl;

    public Taxi(){

    }

    public Taxi(String name, String telNumber, String latitude, String longitude, String imageUrl) {
        this.name = name;
        this.telNumber = telNumber;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
