package com.md.model;

import java.util.Date;

public class RequestModel {

    private String city;
    private String countryCode;

    private RequestModel(final Builder builder) {
        this.city = builder.city;
        this.countryCode = builder.countryCode;
    }

    @Override
    public String toString() {
        return city + " " + countryCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public static class Builder {

        private String city;
        private String countryCode;

        public Builder city(final String city) {
            this.city = city;
            return this;
        }

        public Builder countryCode(final String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public RequestModel build() {
            return new RequestModel(this);
        }
    }
}
