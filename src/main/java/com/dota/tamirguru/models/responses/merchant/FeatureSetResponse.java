/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.responses.merchant;

import com.dota.tamirguru.enums.Feature;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class FeatureSetResponse {

    @Schema(description = "Merchant additional filter feature", example = "CAR_BRAND")
    private Feature feature;

    @ArraySchema(schema = @Schema(description = "Merchant additional filter details", implementation = FeatureValue.class))
    private Set<FeatureValue> values = new HashSet<>();

}
