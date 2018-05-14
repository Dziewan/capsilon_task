package com.md.service.impl;

import com.md.model.RequestModel;
import com.md.service.ValidationCode;
import com.md.service.ValidationService;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ValidationImpl implements ValidationService {

    char[] wrongSigns = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '=', '{', '}'};

    private final int HOUR = 3600000;

    @Override
    public int validateRequest(RequestModel model) {

        if (!checkCharacters(model.getCity()) || !checkCharacters(model.getCountryCode())) {
            return ValidationCode.FAIL;
        }

        if (model.getCity().isEmpty() || model.getCountryCode().isEmpty()) {
            return ValidationCode.FAIL;
        }

        // TODO another validation cases

        return ValidationCode.OK;
    }

    @Override
    public int validateTimestamp(Date lastTime) {
        Date currentTime = new Date();
        if (currentTime.getTime() - lastTime.getTime() < HOUR) {
            return ValidationCode.OK;
        }

        return ValidationCode.FAIL;
    }

    private boolean checkCharacters(String val) {
        for (char sign : wrongSigns) {
            if (val.contains(sign+"")) {
                return false;
            }
        }

        return true;
    }
}
