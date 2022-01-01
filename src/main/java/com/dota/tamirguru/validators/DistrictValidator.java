/*
 * @author : Oguz Kahraman
 * @since : 28.02.2021
 *
 * Copyright - Tamir Guru Java API
 **/
package com.dota.tamirguru.validators;

import com.dota.tamirguru.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class DistrictValidator implements ConstraintValidator<District, Long> {

    @Autowired
    private LocationService locationService;

    @Override
    public boolean isValid(Long field, ConstraintValidatorContext context) {
        return locationService.existByDistrictId(field);
    }

}
