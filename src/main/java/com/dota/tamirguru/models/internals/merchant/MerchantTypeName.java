/*
 * @author : Oguz Kahraman
 * @since : 23 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.internals.merchant;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MerchantTypeName {

    @Schema(description = "Merchant type", example = "Oto Tamirci")
    private String name;

    @Schema(description = "Merchant type Id", example = "OTMR")
    private String typeId;

}

