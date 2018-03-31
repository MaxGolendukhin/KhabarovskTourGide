package com.golendukhin.khabarovsktourgide;

import java.io.Serializable;

class Sight implements Serializable{
    private String name;
    private String description;
    private String address;
    private String phone;
    private String site;
    private int imageResourceId;

    Sight(String name, String description, String address, String phone, String site, int imageResourceId) {
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.site = site;
        this.name = name;
        this.imageResourceId = imageResourceId;

    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getSite() {
        return site;
    }

    public String getName() {
        return name;
    }
}