/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.requests.merchant;

import com.dota.tamirguru.enums.Feature;
import com.dota.tamirguru.validators.City;
import com.dota.tamirguru.validators.District;
import com.dota.tamirguru.validators.Merchant;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
public class MerchantFilter {

    @ArraySchema(schema = @Schema(description = "Merchant Type Id", example = "OTMR"))
    @Merchant
    private Set<@NotBlank String> types = new HashSet<>();

    @ArraySchema(schema = @Schema(description = "District Ids", example = "1"))
    private Set<@NotNull @District Long> districts = new HashSet<>();

    @ArraySchema(schema = @Schema(description = "City Codes", example = "1"))
    private Set<@NotBlank @City String> cities = new HashSet<>();

    @ArraySchema(schema = @Schema(description = "Additional feature types", example = "CAR_BRAND"))
    private Set<Feature> features = new HashSet<>();

    @ArraySchema(schema = @Schema(description = "Additional feature values", example = "1"))
    private Set<Long> values;

}
