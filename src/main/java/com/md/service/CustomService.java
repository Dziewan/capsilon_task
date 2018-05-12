package com.md.service;

import com.md.model.DataModel;
import org.springframework.http.ResponseEntity;

public interface CustomService {

    ResponseEntity<?> getData(String cityName, String countryCode);

    String hello();
}
