package com.md.service;

import com.md.model.CacheModel;

import java.util.Map;

public interface CacheService {

    Map<String, CacheModel> getCache();
}
