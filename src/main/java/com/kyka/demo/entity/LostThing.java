package com.kyka.demo.entity;

import java.util.Date;

public class LostThing {
    private int lostThingId;

    private String name;

    private String place;

    private Date lostTime;

    private String contactWay;

    private String picturePath;

    private String description;

    private int type;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLostThingId() {
        return lostThingId;
    }

    public void setLostThingId(int lostThingId) {
        this.lostThingId = lostThingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getLostTime() {
        return lostTime;
    }

    public void setLostTime(Date lostTime) {
        this.lostTime = lostTime;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
