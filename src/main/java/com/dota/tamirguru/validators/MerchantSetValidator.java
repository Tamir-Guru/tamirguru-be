/*
 * @author : Oguz Kahraman
 * @since : 28.02.2021
 *
 * Copyright - Collige Java API
 **/
package com.dota.tamirguru.validators;

import com.dota.tamirguru.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Set;

@Component
public class MerchantSetValidator implements ConstraintValidator<Merchant, Set<String>> {

    @Autowired
    private MerchantService merchantService;

    @Override
    public boolean isValid(Set<String> field, ConstraintValidatorContext context) {
        if (field.isEmpty()) {
            return true;
        }
        return merchantService.getMerchantMap().containsAll(field);
    }

}
