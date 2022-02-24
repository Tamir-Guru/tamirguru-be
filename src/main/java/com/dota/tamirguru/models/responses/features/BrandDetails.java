/*
 * @author : Oguz Kahraman
 * @since : 18.02.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.models.responses.features;

import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.Data;

@Data
@Schema(description = "Brand Detail Response")
public class BrandDetails {

    @SchemaType(example = "AUDI", description = "Brand Name", required = false)
    private String brandName;
    @SchemaType(example = "CAR_BRAND", description = "Brand Type", required = false)
    private String brandType;
    @SchemaType(example = "AUDI", description = "Brand Description", required = false)
    private String brandDescription;

}
