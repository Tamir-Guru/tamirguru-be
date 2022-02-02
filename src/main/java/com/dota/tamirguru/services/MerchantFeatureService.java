/*
 * @author : Oguz Kahraman
 * @since : 30 Oca 2022
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.services;

import com.dota.tamirguru.entitites.Feature;
import com.dota.tamirguru.models.responses.features.FeatureResponse;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

public interface MerchantFeatureService {
    Map<String, Feature> getFeatures();

    Feature getFeature(String featureName);

    @Cacheable("featureDetails")
    List<FeatureResponse> getFeaturesByCategory(String category);
}
