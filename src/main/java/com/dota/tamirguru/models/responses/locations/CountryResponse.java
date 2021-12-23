/*
 * @author : Oguz Kahraman
 * @since : 23 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.responses.locations;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryResponse {

    @Schema(description = "Name of country", example = "Türkiye")
    private String name;

    @Schema(description = "Code of country", example = "TR")
    private String code;

    @Schema(description = "Phone prefix of country", example = "+90")
    private String phoneCode;

}
