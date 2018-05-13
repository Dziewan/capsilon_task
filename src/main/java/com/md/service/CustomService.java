package com.md.service;

import org.springframework.http.ResponseEntity;

public interface CustomService {

    ResponseEntity<?> getData(String cityName, String countryCode);

    String hello();
}
