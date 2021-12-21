/*
 * @author : Oguz Kahraman
 * @since : 21 Ara 2021
 * <p>
 * Copyright - TamirGuru
 **/
package com.dota.tamirguru.services.impl;

import com.dota.tamirguru.entitites.City;
import com.dota.tamirguru.entitites.Country;
import com.dota.tamirguru.entitites.District;
import com.dota.tamirguru.repositories.LocationRepository;
import com.dota.tamirguru.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Cacheable(cacheNames = "countries")
    @Override
    public List<Country> getCountries(String language) {
        return locationRepository.getCountryList(language);
    }

    @Cacheable(cacheNames = "cities")
    @Override
    public List<City> getCities(String language, String countryCode) {
        return locationRepository.getCityList(language, countryCode);
    }

    @Cacheable(cacheNames = "districts")
    @Override
    public List<District> getDistricts(String language, String cityId) {
        return locationRepository.getDistrictList(language, cityId);
    }


}
