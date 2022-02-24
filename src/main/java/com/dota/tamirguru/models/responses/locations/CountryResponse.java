/*
 * @author : Oguz Kahraman
 * @since : 23 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.responses.locations;

import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Country Detail Response")
public class CountryResponse {

    @SchemaType(example = "Turkey", description = "Country Name", required = false)
    private String name;
    @SchemaType(example = "TR", description = "Country code", required = false)
    private String code;
    @SchemaType(example = "+90", description = "Country phone code", required = false)
    private String phoneCode;

}
