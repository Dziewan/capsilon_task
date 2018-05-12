package com.md.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.md.service.CustomService;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseModel {
}
