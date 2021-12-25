/*
 * @author : Oguz Kahraman
 * @since : 23 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.responses.merchant;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class MerchantResponse {

    @Schema(description = "Merchant Name", example = "Test Oto Tamirci")
    private String merchantName;

    @Schema(description = "Merchant Phone Number", example = "5398760896")
    private String phoneNumber;

    @Schema(description = "Merchant Address", example = "Fsm Mah. No:22")
    private String fullAddress;

    @Schema(description = "Country phone code", example = "+90")
    private String countryPhoneCode;

    @Schema(description = "Country name", example = "Türkiye")
    private String countryName;

    @Schema(description = "City name", example = "Ordu")
    private String cityName;

    @Schema(description = "Region name", example = "Null")
    private String regionName;

    @Schema(description = "District name", example = "Altınordu")
    private String districtName;

    @Schema(description = "Address District Id", example = "41.095138367765934")
    private Double longitude;

    @Schema(description = "Address District Id", example = "29.032444567236276")
    private Double latitude;

    @Schema(description = "Available merchant types", example = "Test Oto Tamirci")
    private Set<String> merchantTypes;

    @ArraySchema(schema = @Schema(description = "Merchant details", implementation = MerchantFeatureResponse.class))
    private Set<MerchantFeatureResponse> features = new HashSet<>();

}
