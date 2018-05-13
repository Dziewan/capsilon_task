package com.md.service.impl;

import com.md.model.CacheModel;
import com.md.service.CacheService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CacheImpl implements CacheService {

    public Map<String, CacheModel> cache;

    public CacheImpl() {
        cache = new HashMap<>();
    }

    @Override
    public Map<String, CacheModel> getCache() {
        return cache;
    }
}
