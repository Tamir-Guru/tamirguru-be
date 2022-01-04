/*
 * @author : Oguz Kahraman
 * @since : 23 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.requests.merchant;

import com.dota.tamirguru.validators.District;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class MerchantCreateRequest {

    @NotBlank
    private String merchantName;

    @NotBlank
    @Length(min = 9, max = 11)
    private String phoneNumber;

    @NotNull
    private Set<@Valid MerchantFeatureRequest> merchantFeatures;

    @NotBlank
    private String fullAddress;

    @NotNull
    @District
    private Long districtId;

    @NotNull
    private Double longitude;

    @NotNull
    private Double latitude;

}