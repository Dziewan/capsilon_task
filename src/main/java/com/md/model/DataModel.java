package com.md.model;

import java.util.List;

public class DataModel extends BaseModel {

    private String cod;
    private double message;
    private int cnt;
    private List<DayModel> list;
    private CityModel city;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<DayModel> getList() {
        return list;
    }

    public void setList(List<DayModel> list) {
        this.list = list;
    }

    public CityModel getCity() {
        return city;
    }

    public void setCity(CityModel city) {
        this.city = city;
    }
}
