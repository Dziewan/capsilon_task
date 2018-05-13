package com.md.model;

import java.util.Date;

public class CacheModel {

    private ResponseModel responseModel;
    private Date timestamp;

    public CacheModel(ResponseModel responseModel, Date timestamp) {
        this.responseModel = responseModel;
        this.timestamp = timestamp;
    }

    public ResponseModel getResponseModel() {
        return responseModel;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
