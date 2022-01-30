/*
 * @author : Oguz Kahraman
 * @since : 30 Oca 2022
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.services;

import java.util.List;

public interface BrandService {
    List<Long> getFeatureBrands(String featureType);
}
