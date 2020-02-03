package com.ozibolme.dikilim.Classes;

public class New {

    private String title;
    private String content;
    private String author;
    private String date;

    public New(){

    }

    public New(String title, String content, String author, String date) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }
}
