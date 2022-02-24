/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.requests.merchant;

import com.dota.tamirguru.validators.Merchant;
import com.dota.tamirguru.validators.MerchantFeature;
import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@MerchantFeature
@Schema(description = "Merchant Feature Create Request")
public class MerchantFeatureRequest {

    @NotNull
    @Merchant
    @SchemaType(example = "OELK", description = "Merchant category type")
    private String merchantTypes;

    @SchemaType(description = "Merchant feature type details", required = false)
    private Set<FeatureSet> featureSet;
}
