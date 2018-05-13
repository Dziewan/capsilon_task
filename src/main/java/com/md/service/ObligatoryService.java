package com.md.service;

import com.md.model.dto.DayDto;

import java.util.List;

public interface ObligatoryService {

    double averageTemperature(List<DayDto> model);

    double averagePressure(List<DayDto> model);

    double averageHumidity(List<DayDto> model);
}
