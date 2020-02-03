package com.ozibolme.dikilim.Classes;

public class Teacher {

    private String name,surname;
    private String lessonName,lessonDescription,fee;
    private String teacherInfos,telNumber,imageUrl;

    public Teacher(){

    }

    public Teacher(String name, String surname, String lessonName, String lessonDescription, String fee, String teacherInfos, String telNumber, String imageUrl) {
        this.name = name;
        this.surname = surname;
        this.lessonName = lessonName;
        this.lessonDescription = lessonDescription;
        this.fee = fee;
        this.teacherInfos = teacherInfos;
        this.telNumber = telNumber;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLessonName() {
        return lessonName;
    }

    public String getLessonDescription() {
        return lessonDescription;
    }

    public String getFee() {
        return fee;
    }

    public String getTeacherInfos() {
        return teacherInfos;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
