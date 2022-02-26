/*
 * @author : Oguz Kahraman
 * @since : 23 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.internals.merchant;

import com.dota.tamirguru.models.responses.features.FeatureResponse;
import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Schema(description = "Merchant Category Response")
public class MerchantTypeName {

    @SchemaType(example = "example", description = "Name of category")
    private String name;
    @SchemaType(example = "OELK", description = "Category type ID")
    private String typeId;
    @SchemaType(example = "OTMBL", description = "Parent Category type ID")
    private Long parentId;
    @SchemaType(example = "3", description = "Category ID")
    private Long id;
    @SchemaType(description = "Category Features")
    private List<FeatureResponse> features;

}

