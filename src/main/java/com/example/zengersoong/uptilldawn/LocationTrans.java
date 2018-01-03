package com.example.zengersoong.uptilldawn;

/**
 * Created by soong on 11/30/17.
 */

public class LocationTrans {

    private String location, transport;
    private int icon;

    public LocationTrans(String location, String transport) {
        this.location = location;
        this.transport = transport;

    }

    public String getLocation() {
        return location;
    }

    public String getTransport() {
        return transport;
    }


    @Override
    public String toString() {
        return "LocationTrans{" +
                "location='" + location + '\'' +
                ", transport='" + transport + '\'' +

                '}';
    }
}
