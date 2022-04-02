/*
 * @author : Oguz Kahraman
 * @since : 3.02.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.models.responses.features;

import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Feature Detail Response")
public class FeatureResponse {

    @SchemaType(example = "CAR_BRAND", description = "Feature Name", required = false)
    private String name;
    @SchemaType(example = "Araba Markası", description = "Feature Description", required = false)
    private String description;
    @SchemaType(description = "Brand Details", required = false)
    private List<BrandDetails> brandDetails;

}
