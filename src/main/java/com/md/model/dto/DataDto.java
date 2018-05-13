package com.md.model.dto;

import com.md.model.BaseModel;

import java.util.List;

public class DataDto extends BaseModel {

    private String cod;
    private double message;
    private int cnt;
    private List<DayDto> list;
    private CityDto city;

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

    public List<DayDto> getList() {
        return list;
    }

    public void setList(List<DayDto> list) {
        this.list = list;
    }

    public CityDto getCity() {
        return city;
    }

    public void setCity(CityDto city) {
        this.city = city;
    }
}
