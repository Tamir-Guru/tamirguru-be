/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.requests.merchant;

import com.dota.tamirguru.validators.Merchant;
import com.dota.tamirguru.validators.MerchantFeature;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@MerchantFeature
public class MerchantFeatureRequest {

    @Schema(description = "Merchant Type Id", example = "OTMR", required = true)
    @NotNull
    @Merchant
    private String merchantTypes;

    @ArraySchema(schema = @Schema(description = "Merchant additional features for given types", implementation = FeatureSet.class))
    private Set<FeatureSet> featureSet;
}
