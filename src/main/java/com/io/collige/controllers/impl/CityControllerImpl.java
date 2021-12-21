/**
 * @author : Oguz Kahraman
 * @since : 21 Ara 2021
 * <p>
 * Copyright - fastmeet
 **/
package com.io.collige.controllers.impl;

import com.io.collige.controllers.CityController;
import com.io.collige.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityControllerImpl implements CityController {

    @Autowired
    private CityService cityService;


    @Override
    public ResponseEntity<List<String>> getCities() {
        return ResponseEntity.ok(cityService.getCities());
    }

    @Override
    public ResponseEntity<List<String>> getDistricts(String cityName) {
        return ResponseEntity.ok(cityService.getDistricts(cityName));
    }
}
