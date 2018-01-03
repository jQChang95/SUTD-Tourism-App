package com.example.zengersoong.uptilldawn;

/**
 * Created by soong on 11/30/17.
 */

public class LocationTransMoney {

    private String location, transport, money;

    public LocationTransMoney(String location, String transport, String money) {
        this.location = location;
        this.transport = transport;
        this.money = money;
    }

    public String getLocation() {
        return location;
    }

    public String getTransport() {
        return transport;
    }

    public String getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "LocationTransMoney{" +
                "location='" + location + '\'' +
                ", transport='" + transport + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
