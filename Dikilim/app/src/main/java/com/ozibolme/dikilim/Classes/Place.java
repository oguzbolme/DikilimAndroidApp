package com.ozibolme.dikilim.Classes;

public class Place {

    private String name;
    private String description;
    private String imageUrl1,imageUrl2,imageUrl3,imageUrl4;
    private String latitude,longitude;

    public Place(){

    }

    public Place(String name, String description, String imageUrl1, String imageUrl2, String imageUrl3, String imageUrl4, String latitude, String longitude) {
        this.name = name;
        this.description = description;
        this.imageUrl1 = imageUrl1;
        this.imageUrl2 = imageUrl2;
        this.imageUrl3 = imageUrl3;
        this.imageUrl4 = imageUrl4;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl1() {
        return imageUrl1;
    }

    public String getImageUrl2() {
        return imageUrl2;
    }

    public String getImageUrl3() {
        return imageUrl3;
    }

    public String getImageUrl4() {
        return imageUrl4;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
