package com.md.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseModel {

    private String cityName;
    private String countryCode;
    private double averageTemperature;
    private double averagePressure;
    private double averageHumidity;

    private ResponseModel(final Builder builder) {
        this.cityName = builder.cityName;
        this.countryCode = builder.countryCode;
        this.averageTemperature = builder.averageTemperature;
        this.averagePressure = builder.averagePressure;
        this.averageHumidity = builder.averageHumidity;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public double getAveragePressure() {
        return averagePressure;
    }

    public void setAveragePressure(double averagePressure) {
        this.averagePressure = averagePressure;
    }

    public double getAverageHumidity() {
        return averageHumidity;
    }

    public void setAverageHumidity(double averageHumidity) {
        this.averageHumidity = averageHumidity;
    }

    public static class Builder {

        private String cityName;
        private String countryCode;
        private double averageTemperature;
        private double averagePressure;
        private double averageHumidity;

        public Builder cityName(final String cityName) {
            this.cityName = cityName;
            return this;
        }

        public Builder countryCode(final String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder averageTemperature(final double averageTemperature) {
            this.averageTemperature = averageTemperature;
            return this;
        }

        public Builder averagePressure(final double averagePressure) {
            this.averagePressure = averagePressure;
            return this;
        }

        public Builder averageHumidity(final double averageHumidity) {
            this.averageHumidity = averageHumidity;
            return this;
        }

        public ResponseModel build() {
            return new ResponseModel(this);
        }
    }
}
