/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.responses.merchant;

import com.dota.tamirguru.validators.MerchantFeature;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@MerchantFeature
public class MerchantFeatureResponse {

    @Schema(description = "Merchant Type Id", example = "OTMR")
    private String merchantTypeId;

    @Schema(description = "Merchant Type Name", example = "Oto Tamir")
    private String merchantType;

    @ArraySchema(schema = @Schema(description = "Merchant additional features for given types", implementation = FeatureSetResponse.class))
    private Set<FeatureSetResponse> featureSet = new HashSet<>();
}
