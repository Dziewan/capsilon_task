package com.md.model;

public class CityModel extends BaseModel {

    public CityModel() {}

    private int id;
    private String name;
    private CoordModel coord;
    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoordModel getCoord() {
        return coord;
    }

    public void setCoord(CoordModel coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
