package com.ozibolme.dikilim.Classes;

public class Announcement {

    private String advert;
    private String contact;
    private String date;

    public Announcement(){

    }

    public Announcement(String advert, String contact, String date) {
        this.advert = advert;
        this.contact = contact;
        this.date = date;
    }

    public String getAdvert() {
        return advert;
    }

    public String getContact() {
        return contact;
    }

    public String getDate() {
        return date;
    }
}
