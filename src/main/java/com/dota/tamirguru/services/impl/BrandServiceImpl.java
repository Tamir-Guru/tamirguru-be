/*
 * @author : Oguz Kahraman
 * @since : 30 Oca 2022
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.services.impl;

import com.dota.tamirguru.entitites.Brand;
import com.dota.tamirguru.repositories.BrandRepository;
import com.dota.tamirguru.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Long> getFeatureBrands(String featureType) {
        return brandRepository.findByFeatureType(featureType).stream().map(Brand::getId).toList();
    }

}
