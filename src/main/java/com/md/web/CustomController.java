package com.md.web;

import com.google.gson.Gson;
import com.md.model.DataModel;
import com.md.service.CustomService;
import com.md.setup.Values;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CustomController implements CustomService {

    private String URL = "http://samples.openweathermap.org/data/2.5/forecast?q={cityName},{countryCode}&appid=b6907d289e10d714a6e88b30761fae22";

    private OkHttpClient client;
    private Gson gson;

    public CustomController() {
        client = new OkHttpClient();
        gson = new Gson();
    }

    @Override
    @RequestMapping(value = "getData/{cityName}/{countryCode}", method = RequestMethod.GET)
    public ResponseEntity<?> getData(@PathVariable String cityName, @PathVariable String countryCode) {

        String url = URL.replace("{cityName}", cityName).replace("{countryCode}", countryCode);
        DataModel model = execute(url);

        if (model == null) {
            return new ResponseEntity<>(Values.BAD_REQUEST_ERROR, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "status", method = RequestMethod.GET)
    public String hello() {
        return "Service works";
    }

    private DataModel execute(String url) {

        Request request = new Request.Builder()
                .url(URL)
                .build();

        Response response = null;
        String responseBody = "";
        try {
            response = client.newCall(request).execute();
            responseBody = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return gson.fromJson(responseBody, DataModel.class);
    }
}
