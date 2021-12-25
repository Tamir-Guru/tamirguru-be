/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.enums;

import com.dota.tamirguru.constants.CacheName;
import com.dota.tamirguru.constants.FeatureTableName;
import com.dota.tamirguru.constants.LocationConstant;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
public enum Feature {

    CAR_BRAND(new HashSet<>(Arrays.asList("OTMR", "OELK")), CacheName.CAR_BRAND, FeatureTableName.CAR_BRAND, LocationConstant.CAR_BRAND_PREFIX);

    private final Set<String> merchantTypes;
    private final String cacheName;
    private final String tableName;
    private final String location;

    Feature(Set<String> merchantTypes, String cacheName, String tableName, String location) {
        this.merchantTypes = merchantTypes;
        this.cacheName = cacheName;
        this.tableName = tableName;
        this.location = location;
    }

    public boolean contains(String merchantSet) {
        return this.merchantTypes.contains(merchantSet);
    }

}
