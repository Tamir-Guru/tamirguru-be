/*
 * @author : Oguz Kahraman
 * @since : 30 Oca 2022
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.services.impl;

import com.dota.tamirguru.core.exception.GuruException;
import com.dota.tamirguru.entitites.Feature;
import com.dota.tamirguru.repositories.FeatureRepository;
import com.dota.tamirguru.services.MerchantFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class MerchantFeatureServiceImpl implements MerchantFeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    @Override
    @Cacheable("allFeatures")
    public Map<String, Feature> getFeatures() {
        Iterable<Feature> featureIterator = featureRepository.findAll();
        Stream<Feature> featureStream = StreamSupport.stream(featureIterator.spliterator(), false);
        return featureStream.collect(Collectors.toMap(Feature::getName, Function.identity()));
    }

    @Override
    @Cacheable("feature")
    public Feature getFeature(String featureName) {
        return featureRepository.findById(featureName).orElseThrow(() ->
                new GuruException(HttpStatus.BAD_REQUEST, "Feature couldn't find", "FTR_ERR"));
    }

}
