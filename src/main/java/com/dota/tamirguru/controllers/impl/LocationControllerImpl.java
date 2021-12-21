/*
 * @author : Oguz Kahraman
 * @since : 21 Ara 2021
 * <p>
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.controllers.impl;

import com.dota.tamirguru.controllers.LocationController;
import com.dota.tamirguru.core.i18n.Translator;
import com.dota.tamirguru.entitites.City;
import com.dota.tamirguru.entitites.Country;
import com.dota.tamirguru.entitites.District;
import com.dota.tamirguru.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationControllerImpl implements LocationController {

    @Autowired
    private LocationService locationService;

    @Override
    public ResponseEntity<List<Country>> getCountries() {
        List<Country> countries = locationService.getCountries(Translator.getLanguageUpper());
        if (countries.isEmpty()) {
            return ResponseEntity.ok(locationService.getCountries(Translator.getDefaultLanguageUpper()));
        }
        return ResponseEntity.ok(countries);
    }

    @Override
    public ResponseEntity<List<City>> getCities(String countryCode) {
        List<City> cities = locationService.getCities(Translator.getLanguageUpper(), countryCode);
        if (cities.isEmpty()) {
            return ResponseEntity.ok(locationService.getCities(Translator.getDefaultLanguageUpper(), countryCode));
        }
        return ResponseEntity.ok(cities);
    }

    @Override
    public ResponseEntity<List<District>> getDistricts(String cityId) {
        List<District> districts = locationService.getDistricts(Translator.getLanguageUpper(), cityId);
        if (districts.isEmpty()) {
            return ResponseEntity.ok(locationService.getDistricts(Translator.getDefaultLanguageUpper(), cityId));
        }
        return ResponseEntity.ok(districts);
    }

}
