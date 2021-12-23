/*
 * @author : Oguz Kahraman
 * @since : 23 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.requests.merchant;

import com.dota.tamirguru.validators.District;
import com.dota.tamirguru.validators.Merchant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class MerchantCreateRequest {

    @Schema(description = "Merchant Name", example = "Test Oto Tamirci", required = true)
    @NotBlank
    private String merchantName;

    @Schema(description = "Merchant Phone Number", example = "5398760896", required = true)
    @NotBlank
    @Length(min = 9, max = 11)
    private String phoneNumber;

    @Schema(description = "Merchant Type Id", example = "OTMR", required = true)
    @NotBlank
    @Merchant
    private String merchantTypeId;

    @Schema(description = "Merchant Address", example = "Fsm Mah. No:22", required = true)
    @NotBlank
    private String fullAddress;

    @Schema(description = "Address District Id", example = "1", required = true)
    @NotNull
    @District
    private Long districtId;

    @Schema(description = "Address District Id", example = "41.095138367765934", required = true)
    @NotNull
    private Double longitude;

    @Schema(description = "Address District Id", example = "29.032444567236276", required = true)
    @NotNull
    private Double latitude;

}