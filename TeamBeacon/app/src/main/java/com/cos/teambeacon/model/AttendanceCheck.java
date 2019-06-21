package com.cos.teambeacon.model;

public class AttendanceCheck {

    int id;
    String createDate;
    String updateDate;
    String checking;

    public AttendanceCheck(String checking, String createDate) {
        this.checking = checking;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getChecking() {
        return checking;
    }

    public void setChecking(String checking) {
        this.checking = checking;
    }
}
