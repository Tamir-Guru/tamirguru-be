/*
 * @author : Oguz Kahraman
 * @since : 23 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.responses.merchant;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class MerchantResponse {

    private Long id;
    private String merchantName;
    private String email;
    private String phoneNumber;
    private String fullAddress;
    private String countryPhoneCode;
    private String countryName;
    private String cityName;
    private String regionName;
    private String districtName;
    private Double longitude;
    private Double latitude;
    private Set<String> merchantTypes;
    private Set<MerchantFeatureResponse> features = new HashSet<>();

}
