package com.md.model;

import java.util.List;

public class DayModel extends BaseModel {

    private long dt;
    private ValuesModel main;
    private List<WeatherModel> weather;
    private CloudsModel clouds;
    private WindModel wind;
    private RainModel rain;
    private SnowModel snow;
    private SysModel sys;
    private String dt_txt;

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public ValuesModel getMain() {
        return main;
    }

    public void setMain(ValuesModel main) {
        this.main = main;
    }

    public List<WeatherModel> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherModel> weather) {
        this.weather = weather;
    }

    public CloudsModel getClouds() {
        return clouds;
    }

    public void setClouds(CloudsModel clouds) {
        this.clouds = clouds;
    }

    public WindModel getWind() {
        return wind;
    }

    public void setWind(WindModel wind) {
        this.wind = wind;
    }

    public RainModel getRain() {
        return rain;
    }

    public void setRain(RainModel rain) {
        this.rain = rain;
    }

    public SnowModel getSnow() {
        return snow;
    }

    public void setSnow(SnowModel snow) {
        this.snow = snow;
    }

    public SysModel getSys() {
        return sys;
    }

    public void setSys(SysModel sys) {
        this.sys = sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}
