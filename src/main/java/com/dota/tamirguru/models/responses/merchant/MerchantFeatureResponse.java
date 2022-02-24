/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.responses.merchant;

import com.dota.tamirguru.validators.MerchantFeature;
import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@MerchantFeature
@Schema(description = "Merchant Feature response")
public class MerchantFeatureResponse {

    @SchemaType(example = "1", description = "Merchant type detail id", required = false)
    private String merchantTypeId;
    @SchemaType(example = "OELK", description = "Merchant type detail for given type", required = false)
    private String merchantType;
    @SchemaType(description = "Merchant feature details", required = false)
    private Set<FeatureSetResponse> featureSet = new HashSet<>();
}
