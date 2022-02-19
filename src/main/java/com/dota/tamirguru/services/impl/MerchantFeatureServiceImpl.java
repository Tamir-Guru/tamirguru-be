/*
 * @author : Oguz Kahraman
 * @since : 30 Oca 2022
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.services.impl;

import com.dota.tamirguru.core.exception.GuruException;
import com.dota.tamirguru.core.i18n.Translator;
import com.dota.tamirguru.entitites.Feature;
import com.dota.tamirguru.models.responses.features.FeatureResponse;
import com.dota.tamirguru.repositories.FeatureRepository;
import com.dota.tamirguru.services.BrandService;
import com.dota.tamirguru.services.MerchantFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class MerchantFeatureServiceImpl implements MerchantFeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    @Autowired
    private BrandService brandService;

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

    @Override
    @Cacheable("featureDetails")
    public List<FeatureResponse> getFeaturesByCategory(String category, String language) {
        List<FeatureResponse> featureResponseList = new ArrayList<>();
        List<Feature> features = featureRepository.getFeaturesFromType(category);
        for (Feature feature : features) {
            FeatureResponse featureResponse = new FeatureResponse();
            featureResponse.setName(feature.getName());
            featureResponse.setDescription(Translator.getMessage("label.feature." + feature.getCacheName()));
            featureResponse.setBrandDetails(brandService.getBrandDetails(feature.getName()));
            featureResponseList.add(featureResponse);
        }
        return featureResponseList;
    }

}
