/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.requests.merchant;

import com.dota.tamirguru.validators.City;
import com.dota.tamirguru.validators.District;
import com.dota.tamirguru.validators.Merchant;
import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Schema(description = "Merchant Filter Request")
public class MerchantFilter {

    @Merchant
    @SchemaType(example = "OELK", description = "Search by merchant type", required = false)
    private Set<@NotBlank String> types = new HashSet<>();

    @SchemaType(example = "1", description = "Search by District id", required = false)
    private Set<@NotNull @District Long> districts = new HashSet<>();

    @SchemaType(description = "Search by coordinates", required = false)
    private DistanceFilter distance;

    @SchemaType(example = "1", description = "Search by City id", required = false)
    private Set<@NotBlank @City String> cities = new HashSet<>();

    @SchemaType(example = "CAR_BRAND", description = "Search by feature type", required = false)
    private Set<String> features = new HashSet<>();

    @SchemaType(example = "1", description = "Search by feature id", required = false)
    private Set<Long> values;

}
