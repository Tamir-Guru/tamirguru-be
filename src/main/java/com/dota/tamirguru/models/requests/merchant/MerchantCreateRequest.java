/*
 * @author : Oguz Kahraman
 * @since : 23 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.requests.merchant;

import com.dota.tamirguru.validators.District;
import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Schema(description = "Merchant Crate Request")
public class MerchantCreateRequest {

    @NotBlank
    @SchemaType(example = "example", description = "Name of merhant")
    private String merchantName;

    @NotBlank
    @Length(min = 9, max = 11)
    @SchemaType(example = "5555555555", description = "Phone number of merchant")
    private String phoneNumber;

    @Email
    @SchemaType(example = "example@merchant.com", description = "Email of merchant")
    private String email;

    @NotBlank
    @SchemaType(example = "I'm best merchant", description = "Merchant detail description")
    private String details;

    @SchemaType(example = "http://www.example.com", description = "Website of merchant", required = false)
    private String website;

    @NotNull
    @SchemaType(description = "Merchant Features")
    private Set<@Valid MerchantFeatureRequest> merchantFeatures;

    @NotBlank
    @SchemaType(example = "Example cad. Mah.", description = "Address of merchant")
    private String fullAddress;

    @NotNull
    @District
    @SchemaType(example = "1", description = "Id of merchant district")
    private Long districtId;

    @NotNull
    @SchemaType(example = "12.11", description = "Long information")
    private Double longitude;

    @NotNull
    @SchemaType(example = "12.11", description = "Lat information")
    private Double latitude;

}