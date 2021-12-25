/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.requests.merchant;

import com.dota.tamirguru.enums.Feature;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class FeatureSet {

    @Schema(description = "Merchant additional filter feature", example = "CAR_BRAND")
    @NotNull
    private Feature feature;

    @ArraySchema(schema = @Schema(description = "Merchant additional filter id", example = "1"))
    @NotEmpty
    private Set<Long> values;

}
