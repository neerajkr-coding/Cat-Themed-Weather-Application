package com.example.weatherapplication.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Weather {

    @SerializedName("resolvedAddress")
    private String address;

    @SerializedName("description")
    private String Desc;

    @SerializedName("days")
    private ArrayList<Day> dayList;



    public ArrayList<Day> getDayList() {
        return dayList;
    }

    public void setDayList(ArrayList<Day> dayList) {
        this.dayList = dayList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
}
