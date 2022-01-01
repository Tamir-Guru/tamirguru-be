/*
 * @author : Oguz Kahraman
 * @since : 28.02.2021
 *
 * Copyright - Tamir Guru Java API
 **/
package com.dota.tamirguru.validators;

import com.dota.tamirguru.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class MerchantValidator implements ConstraintValidator<Merchant, String> {

    @Autowired
    private MerchantService merchantService;

    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {
        if (field.isEmpty()) {
            return true;
        }
        return merchantService.getMerchantMap().contains(field);
    }

}
