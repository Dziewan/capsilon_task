package com.md.service;

import com.md.model.RequestModel;

import java.util.Date;

public interface ValidationService {

    int validateRequest(RequestModel model);

    int validateTimestamp(Date time);
}
