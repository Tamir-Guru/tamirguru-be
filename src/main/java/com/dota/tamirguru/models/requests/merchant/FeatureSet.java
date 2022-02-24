/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.requests.merchant;

import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Schema(description = "Merchant Feature Details Create Request")
public class FeatureSet {

    @NotNull
    @SchemaType(example = "CAR_BRAND", description = "Feature type")
    private String feature;

    @NotEmpty
    @SchemaType(example = "1", description = "Feature type id")
    private Set<Long> values;

}
