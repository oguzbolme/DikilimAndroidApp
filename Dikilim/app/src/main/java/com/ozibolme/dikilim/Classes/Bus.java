package com.ozibolme.dikilim.Classes;

public class Bus {

    private String name;
    private String imageUrl;

    public Bus(){

    }

    public Bus(String name, String imageUrl){
        this.name = name;
        this.imageUrl=imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
