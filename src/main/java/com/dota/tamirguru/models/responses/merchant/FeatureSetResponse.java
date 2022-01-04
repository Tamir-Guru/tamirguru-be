/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.responses.merchant;

import com.dota.tamirguru.enums.Feature;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class FeatureSetResponse {

    private Feature feature;
    private Set<FeatureValue> values = new HashSet<>();

}
