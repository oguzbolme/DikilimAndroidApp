package com.ozibolme.dikilim.Classes;

public class Plumber {

    private String name,surname;
    private String description,fee;
    private String shopName;
    private String telNumber,imageUrl,workingHours;
    private String latitude,longitude;


    public Plumber(){

    }

    public Plumber(String name, String surname, String description, String fee, String shopName, String telNumber, String imageUrl, String workingHours, String latitude, String longitude) {
        this.name = name;
        this.surname = surname;
        this.description = description;
        this.fee = fee;
        this.shopName = shopName;
        this.telNumber = telNumber;
        this.imageUrl = imageUrl;
        this.workingHours = workingHours;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDescription() {
        return description;
    }

    public String getFee() {
        return fee;
    }

    public String getShopName() {
        return shopName;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
