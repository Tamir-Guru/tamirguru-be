/**
 * @author : Oguz Kahraman
 * @since : 21 Ara 2021
 * <p>
 * Copyright - fastmeet
 **/
package com.io.collige.services.impl;

import com.io.collige.repositories.CityRepository;
import com.io.collige.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class CityServiceImpl implements CityService {

    private static final Locale TR_LOCALE = new Locale("tr", "TR");

    @Autowired
    private CityRepository cityRepository;

    @Cacheable(cacheNames = "cities")
    @Override
    public List<String> getCities() {
        return cityRepository.getCities();
    }

    @Cacheable(cacheNames = "districts")
    @Override
    public List<String> getDistricts(String cityName){
        return cityRepository.getDistricts(cityName.toUpperCase(TR_LOCALE));
    }

}
