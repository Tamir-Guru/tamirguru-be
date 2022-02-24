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
@Schema(description = "District Detail Response")
public class DistrictResponse {

    @SchemaType(example = "Gürgentepe", description = "District Name", required = false)
    private String name;
    @SchemaType(example = "1", description = "District Code", required = false)
    private String code;

}
