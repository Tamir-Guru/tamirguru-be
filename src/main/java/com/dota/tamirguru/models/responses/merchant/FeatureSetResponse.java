/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.responses.merchant;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class FeatureSetResponse {

    private String feature;
    private Set<FeatureValue> values = new HashSet<>();

}
