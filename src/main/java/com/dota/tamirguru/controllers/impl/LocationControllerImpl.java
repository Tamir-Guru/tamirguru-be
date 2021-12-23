/*
 * @author : Oguz Kahraman
 * @since : 21 Ara 2021
 * <p>
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.controllers.impl;

import com.dota.tamirguru.controllers.LocationController;
import com.dota.tamirguru.core.i18n.Translator;
import com.dota.tamirguru.models.responses.locations.CityResponse;
import com.dota.tamirguru.models.responses.locations.CountryResponse;
import com.dota.tamirguru.models.responses.locations.DistrictResponse;
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
    public ResponseEntity<List<CountryResponse>> getCountries() {
        return ResponseEntity.ok(locationService.getCountries(Translator.getLanguageUpper()));
    }

    @Override
    public ResponseEntity<List<CityResponse>> getCities(String countryCode) {
        return ResponseEntity.ok(locationService.getCities(Translator.getDefaultLanguageUpper(), countryCode));
    }

    @Override
    public ResponseEntity<List<DistrictResponse>> getDistricts(String cityId) {
        return ResponseEntity.ok(locationService.getDistricts(Translator.getDefaultLanguageUpper(), cityId));
    }

}
