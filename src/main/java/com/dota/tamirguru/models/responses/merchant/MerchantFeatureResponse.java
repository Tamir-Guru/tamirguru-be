/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.responses.merchant;

import com.dota.tamirguru.validators.MerchantFeature;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@MerchantFeature
public class MerchantFeatureResponse {

    private String merchantTypeId;
    private String merchantType;
    private Set<FeatureSetResponse> featureSet = new HashSet<>();
}
