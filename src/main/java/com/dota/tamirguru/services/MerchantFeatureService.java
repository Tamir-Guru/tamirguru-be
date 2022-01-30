/*
 * @author : Oguz Kahraman
 * @since : 30 Oca 2022
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.services;

import com.dota.tamirguru.entitites.Feature;

import java.util.Map;

public interface MerchantFeatureService {
    Map<String, Feature> getFeatures();

    Feature getFeature(String featureName);
}
