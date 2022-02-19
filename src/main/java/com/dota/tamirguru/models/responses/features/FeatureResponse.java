/*
 * @author : Oguz Kahraman
 * @since : 3.02.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.models.responses.features;

import lombok.Data;

import java.util.List;

@Data
public class FeatureResponse {

    private String name;
    private String description;
    private List<BrandDetails> brandDetails;

}
