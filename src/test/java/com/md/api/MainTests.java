package com.md.api;

import com.md.model.RequestModel;
import com.md.service.CustomService;
import com.md.service.ValidationCode;
import com.md.service.ValidationService;
import com.md.web.CustomController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext_mock.xml" })
public class MainTests {

    String URL = "http://samples.openweathermap.org/data/2.5/forecast?q={cityName},{countryCode}&appid=b6907d289e10d714a6e88b30761fae22";

    @Autowired
    CustomService customService;

    @Autowired
    ValidationService validationService;

    @Test
    public void shouldGetResponse() {
        ResponseEntity<?> responseEntity = customService.getData("Warsaw", "PL");
        assertTrue(responseEntity.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void shouldGetBadRequest() {
        ResponseEntity<?> responseEntity = customService.getData("{}{}", "{{{");
        assertTrue(responseEntity.getStatusCode() == HttpStatus.BAD_REQUEST);
    }

    @Test
    public void validatePathVariable() {
        RequestModel wrong = new RequestModel.Builder()
                .city("{{")
                .countryCode("ds")
                .build();

        RequestModel correct = new RequestModel.Builder()
                .city("Warsaw")
                .countryCode("PL")
                .build();

        int wrongValidation = validationService.validateRequest(wrong);
        int corretValidation = validationService.validateRequest(correct);

        assertTrue(wrongValidation == ValidationCode.FAIL);
        assertTrue(corretValidation == ValidationCode.OK);
    }

    @Test
    public void validateTimestamp() {
        long aLongTimeAgo = new Date().getTime() - (new Date().getTime() >> 1);
        long halfOfHourEarlier = new Date().getTime() - (3600000 >> 1);

        int fail = validationService.validateTimestamp(new Date(aLongTimeAgo));
        int ok = validationService.validateTimestamp(new Date(halfOfHourEarlier));

        assertTrue(fail == ValidationCode.FAIL);
        assertTrue(ok == ValidationCode.OK);
    }
}
