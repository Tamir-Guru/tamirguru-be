/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.validators;

import com.dota.tamirguru.models.requests.merchant.FeatureSet;
import com.dota.tamirguru.models.requests.merchant.MerchantFeatureRequest;
import com.dota.tamirguru.services.MerchantFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Iterator;

@Component
public class MerchantFeatureValidator implements ConstraintValidator<MerchantFeature, MerchantFeatureRequest> {

    @Autowired
    private MerchantFeatureService featureService;

    @Override
    public boolean isValid(MerchantFeatureRequest request, ConstraintValidatorContext context) {
        if (request.getFeatureSet() != null && !request.getFeatureSet().isEmpty()) {
            Iterator<FeatureSet> iterable = request.getFeatureSet().iterator();
            boolean isError = false;
            while (iterable.hasNext() && !isError) {
                FeatureSet feature = iterable.next();
                isError = !(feature.getFeature().contains(request.getMerchantTypes()) &&
                        featureService.existsByIds(feature.getFeature(), feature.getValues()));
            }
            return !isError;
        }
        return true;
    }

}