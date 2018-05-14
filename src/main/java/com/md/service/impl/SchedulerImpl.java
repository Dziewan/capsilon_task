package com.md.service.impl;

import com.md.model.CacheModel;
import com.md.service.CacheService;
import com.md.setup.ValidationCode;
import com.md.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class SchedulerImpl {

    @Autowired
    CacheService cacheService;

    @Autowired
    ValidationService validationService;

    @Scheduled(cron = "* */60 * * * *")
    public synchronized void checkCache() {
        Map<String, CacheModel> cache = cacheService.getCache();
        List<String> toRemove = new ArrayList<>();

        for (String key : cache.keySet()) {
            int timeValidation = validationService.validateTimestamp(cache.get(key).getTimestamp());
            if (timeValidation == ValidationCode.FAIL) {
                toRemove.add(key);
            }
        }

        for (String key : toRemove) {
            cache.remove(key);
        }
    }
}
