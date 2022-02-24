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

@Data
@Schema(description = "Merchant Feature Response")
public class FeatureValue {

    @SchemaType(example = "1", description = "Feature id", required = false)
    private Long value;
    @SchemaType(example = "AUDI", description = "Feature name", required = false)
    private String name;

}
