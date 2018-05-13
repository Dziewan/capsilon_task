package com.md.service.impl;

import com.md.model.dto.DayDto;
import com.md.model.dto.ValuesDto;
import com.md.service.ObligatoryService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
public class ObligatoryImpl implements ObligatoryService {

    @Override
    public double averageTemperature(List<DayDto> data) {
        if (data == null) {
            return 0;
        }

        double result;
        List<Double> temp = new ArrayList<>();

        for (DayDto model : data) {
            if (model != null) {
                ValuesDto values = model.getMain();
                if (values != null) {
                    double average = (values.getTemp_min() + values.getTemp_max()) / 2.0;
                    temp.add(average);
                }
            }
        }

        result = calculate(temp);
        return setPrecision(result);
    }

    @Override
    public double averagePressure(List<DayDto> data) {
        if (data == null) {
            return 0;
        }

        double result;
        List<Double> temp = new ArrayList<>();

        for (DayDto model : data) {
            if (model != null) {
                ValuesDto values = model.getMain();
                if (values != null) {
                    temp.add(values.getPressure());
                }
            }
        }

        result = calculate(temp);
        return setPrecision(result);
    }

    @Override
    public double averageHumidity(List<DayDto> data) {
        if (data == null) {
            return 0;
        }

        double result;
        List<Double> temp = new ArrayList<>();

        for (DayDto model : data) {
            if (model != null) {
                ValuesDto values = model.getMain();
                if (values != null) {
                    temp.add(values.getHumidity());
                }
            }
        }

        result = calculate(temp);
        return setPrecision(result);
    }

    private double calculate(List<Double> data) {
        double result = 0.0;
        int divisor = data.size();

        for (double val : data) {
            result += val;
        }

        return divisor > 0 ? result / divisor : result;
    }

    private double setPrecision(double val) {
        return BigDecimal.valueOf(val).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
