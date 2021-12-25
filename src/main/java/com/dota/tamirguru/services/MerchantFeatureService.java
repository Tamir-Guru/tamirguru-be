/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.services;

import com.dota.tamirguru.enums.Feature;

import javax.annotation.PostConstruct;
import java.util.Set;

public interface MerchantFeatureService {
    @PostConstruct
    void init();

    boolean existsByIds(Feature feature, Set<Long> ids);
}
