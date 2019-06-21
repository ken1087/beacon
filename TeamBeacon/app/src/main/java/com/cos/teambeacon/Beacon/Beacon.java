package com.cos.teambeacon.Beacon;

/**
 * Created by 15U560 on 2017-10-19.
 */

public class Beacon {
    private String address;
    private int rssi;
    private String now;
    private String checking;
    private String createDate;
    private String updateDate;

    public Beacon(String address, int rssi, String now) {
        this.address = address;
        this.rssi = rssi;
        this.now = now;

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }


}
