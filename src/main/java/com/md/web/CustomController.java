package com.md.web;

import com.google.gson.Gson;
import com.md.model.*;
import com.md.model.dto.DataDto;
import com.md.model.dto.DayDto;
import com.md.service.*;
import com.md.setup.Values;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@RestController
public class CustomController implements CustomService {

    @Autowired
    ObligatoryService obligatoryService;

    @Autowired
    ValidationService validationService;

    @Autowired
    CacheService cacheService;

    private String URL = "http://samples.openweathermap.org/data/2.5/forecast?q={cityName},{countryCode}&appid=b6907d289e10d714a6e88b30761fae22";

    private OkHttpClient client;
    private Gson gson;

    public CustomController() {
        client = new OkHttpClient();
        gson = new Gson();
    }

    @Override
    @RequestMapping(value = "getData/{cityName}/{countryCode}", method = RequestMethod.GET)
    public synchronized ResponseEntity<?> getData(@PathVariable String cityName, @PathVariable String countryCode) {
        Map<String, CacheModel> cache = cacheService.getCache();

        RequestModel requestModel = new RequestModel.Builder()
                .city(cityName)
                .countryCode(countryCode)
                .build();

        String requestString = requestModel.toString();

        if (cache.containsKey(requestString)) {
            int timeValidation = validationService.validateTimestamp(cache.get(requestString).getTimestamp());
            if (timeValidation == ValidationCode.OK) {
                return new ResponseEntity<>(cache.get(requestString).getResponseModel(), HttpStatus.OK);
            } else {
                cache.remove(requestString);
            }
        }

        int requestValidation = validationService.validateRequest(requestModel);
        if (requestValidation == ValidationCode.FAIL) {
            return new ResponseEntity<>(Values.BAD_REQUEST_ERROR, HttpStatus.BAD_REQUEST);
        }

        String url = URL.replace("{cityName}", cityName).replace("{countryCode}", countryCode);
        DataDto model = execute(url);

        if (model == null) {
            return new ResponseEntity<>(Values.BAD_REQUEST_ERROR, HttpStatus.BAD_REQUEST);
        }

        List<DayDto> data = model.getList();

        double temperature = obligatoryService.averageTemperature(data);
        double pressure = obligatoryService.averagePressure(data);
        double humidity = obligatoryService.averageHumidity(data);

        ResponseModel responseModel = new ResponseModel.Builder()
                .cityName(cityName)
                .countryCode(countryCode)
                .averageTemperature(temperature)
                .averagePressure(pressure)
                .averageHumidity(humidity)
                .build();

        CacheModel cacheModel = new CacheModel(responseModel, new Date());
        cache.put(requestString, cacheModel);

        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "status", method = RequestMethod.GET)
    public String hello() {
        return "Service works";
    }

    private DataDto execute(String url) {

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = null;
        String responseBody =  "";

        try {
            response = client.newCall(request).execute();
            responseBody = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return gson.fromJson(responseBody, DataDto.class);
    }
}
