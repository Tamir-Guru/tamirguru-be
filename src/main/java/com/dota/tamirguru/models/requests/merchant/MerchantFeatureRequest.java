/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.requests.merchant;

import com.dota.tamirguru.validators.Merchant;
import com.dota.tamirguru.validators.MerchantFeature;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@MerchantFeature
public class MerchantFeatureRequest {

    @NotNull
    @Merchant
    private String merchantTypes;

    private Set<FeatureSet> featureSet;
}
