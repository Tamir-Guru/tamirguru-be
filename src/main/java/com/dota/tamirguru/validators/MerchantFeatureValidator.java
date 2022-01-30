/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.validators;

import com.dota.tamirguru.entitites.Feature;
import com.dota.tamirguru.models.requests.merchant.FeatureSet;
import com.dota.tamirguru.models.requests.merchant.MerchantFeatureRequest;
import com.dota.tamirguru.services.BrandService;
import com.dota.tamirguru.services.MerchantFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Iterator;

@Component
public class MerchantFeatureValidator implements ConstraintValidator<MerchantFeature, MerchantFeatureRequest> {

    @Autowired
    private MerchantFeatureService featureService;

    @Autowired
    private BrandService brandService;

    @Override
    public boolean isValid(MerchantFeatureRequest request, ConstraintValidatorContext context) {
        if (request.getFeatureSet() != null && !request.getFeatureSet().isEmpty()) {
            Iterator<FeatureSet> iterable = request.getFeatureSet().iterator();
            boolean isError = false;
            while (iterable.hasNext() && !isError) {
                FeatureSet feature = iterable.next();
                Feature feature1 = featureService.getFeatures().get(feature.getFeature());
                isError = !(feature1 != null && Arrays.asList(feature1.getCategoryIds()).contains(request.getMerchantTypes()) &&
                        brandService.getFeatureBrands(feature.getFeature()).containsAll(feature.getValues()));
            }
            if (isError) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Feature not found for given type")
                        .addPropertyNode("featureSet").addConstraintViolation();
            }
            return !isError;
        }
        return true;
    }

}