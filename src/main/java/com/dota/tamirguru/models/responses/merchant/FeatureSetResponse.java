/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.responses.merchant;

import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Schema(description = "Merchant Feature Detail response")
public class FeatureSetResponse {

    @SchemaType(example = "CAR_BRAND", description = "Merchant feature type", required = false)
    private String feature;
    @SchemaType(description = "Merchant feature values", required = false)
    private Set<FeatureValue> values = new HashSet<>();

}
