/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.responses.merchant;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FeatureValue {

    @Schema(description = "Feature id", example = "1")
    private Long value;

    @Schema(description = "Feature name", example = "Acura")
    private String name;

}
