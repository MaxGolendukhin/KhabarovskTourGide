package com.golendukhin.khabarovsktourgide;

import java.io.Serializable;

class Sight implements Serializable {
    private String name;
    private String description;
    private String address;
    private String phone;
    private String site;
    private int imageResourceId;
    private String coordinates;

    Sight(String name, String description, String address, String phone, String site, int imageResourceId, String coordinates) {
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.site = site;
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.coordinates = coordinates;
    }

    int getImageResourceId() {
        return imageResourceId;
    }

    String getDescription() {
        return description;
    }

    String getAddress() {
        return address;
    }

    String getPhone() {
        return phone;
    }

    String getSite() {
        return site;
    }

    String getName() {
        return name;
    }

    String getCoordinates() {
        return coordinates;
    }
}