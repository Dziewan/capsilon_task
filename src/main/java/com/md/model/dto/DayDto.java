package com.md.model.dto;

import com.md.model.BaseModel;

import java.util.List;

public class DayDto extends BaseModel {

    private long dt;
    private ValuesDto main;
    private List<WeatherDto> weather;
    private CloudsDto clouds;
    private WindDto wind;
    private RainDto rain;
    private SnowDto snow;
    private SysDto sys;
    private String dt_txt;

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public ValuesDto getMain() {
        return main;
    }

    public void setMain(ValuesDto main) {
        this.main = main;
    }

    public List<WeatherDto> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDto> weather) {
        this.weather = weather;
    }

    public CloudsDto getClouds() {
        return clouds;
    }

    public void setClouds(CloudsDto clouds) {
        this.clouds = clouds;
    }

    public WindDto getWind() {
        return wind;
    }

    public void setWind(WindDto wind) {
        this.wind = wind;
    }

    public RainDto getRain() {
        return rain;
    }

    public void setRain(RainDto rain) {
        this.rain = rain;
    }

    public SnowDto getSnow() {
        return snow;
    }

    public void setSnow(SnowDto snow) {
        this.snow = snow;
    }

    public SysDto getSys() {
        return sys;
    }

    public void setSys(SysDto sys) {
        this.sys = sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}
