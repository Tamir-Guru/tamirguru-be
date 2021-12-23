/*
 * @author : Oguz Kahraman
 * @since : 21 Ara 2021
 * <p>
 * Copyright - TamirGuru
 **/
package com.dota.tamirguru.services.impl;

import com.dota.tamirguru.constants.LocationConstant;
import com.dota.tamirguru.core.i18n.Translator;
import com.dota.tamirguru.models.responses.locations.CityResponse;
import com.dota.tamirguru.models.responses.locations.CountryResponse;
import com.dota.tamirguru.models.responses.locations.DistrictResponse;
import com.dota.tamirguru.repositories.DistrictRepository;
import com.dota.tamirguru.repositories.LocationRepository;
import com.dota.tamirguru.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@SuppressWarnings("java:S3740")
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Cacheable(cacheNames = "countries")
    @Override
    public List<CountryResponse> getCountries(String language) {
        List<CountryResponse> response = new ArrayList<>();
        List<Object[]> countries = locationRepository.getCountryList();
        countries.forEach(item -> response
                .add(new CountryResponse(Translator.getMessage(LocationConstant.COUNTRY_PREFIX + item[0]), item[0].toString(), item[1].toString())));
        return response;
    }

    @Cacheable(cacheNames = "cities")
    @Override
    public List<CityResponse> getCities(String language, String countryCode) {
        List<CityResponse> response = new ArrayList<>();
        List<String> countries = locationRepository.getCityList(countryCode);
        countries.forEach(item -> response
                .add(new CityResponse(Translator.getMessage(LocationConstant.CITY_PREFIX + item), item)));
        return response;
    }

    @Cacheable(cacheNames = "districts")
    @Override
    public List<DistrictResponse> getDistricts(String language, String cityId) {
        List<DistrictResponse> response = new ArrayList<>();
        List<String> countries = locationRepository.getDistrictList(cityId);
        countries.forEach(item -> response
                .add(new DistrictResponse(Translator.getMessage(LocationConstant.DISTRICT_PREFIX + item), item)));
        return response;
    }

    @Override
    public boolean existById(Long districtId) {
        return districtRepository.existsById(districtId);
    }

}
