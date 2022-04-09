/*
 * @author : Oguz Kahraman
 * @since : 23 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.responses.merchant;

import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Schema(description = "Response of merchant details")
public class MerchantResponse {

    @SchemaType(example = "1", description = "Id of user", required = false)
    private Long id;
    @SchemaType(example = "Example Merchant", description = "Name of merchant", required = false)
    private String merchantName;
    @SchemaType(example = "http://www.example.com", description = "Website of merchant", required = false)
    private String website;
    @SchemaType(example = "example@merchant.com", description = "Email of user", required = false)
    private String email;
    @SchemaType(example = "5555555555", description = "Phone number of merchant", required = false)
    private String phoneNumber;
    @SchemaType(example = "https://www.photo.com", description = "Photo url of the user", required = false)
    private String photo;
    @SchemaType(example = "2022-10-10", description = "Merchant creation date", required = false)
    private LocalDate createDate;
    @SchemaType(example = "I'm best merchant", description = "Merchant details", required = false)
    private String details;
    @SchemaType(example = "Example cad. Mah.", description = "Address of merchant", required = false)
    private String fullAddress;
    @SchemaType(example = "+90", description = "Country Phone Code", required = false)
    private String countryPhoneCode;
    @SchemaType(example = "Turkey", description = "Country Name", required = false)
    private String countryName;
    @SchemaType(example = "Ordu", description = "City Name", required = false)
    private String cityName;
    @SchemaType(example = "Karadeniz", description = "Region Name", required = false)
    private String regionName;
    @SchemaType(example = "Güregnetepe", description = "District Name", required = false)
    private String districtName;
    @SchemaType(example = "12", description = "Map coordinate", required = false)
    private Double longitude;
    @SchemaType(example = "12", description = "Map coordinate", required = false)
    private Double latitude;
    @SchemaType(example = "3", description = "Average comment stars", required = false)
    private Double averageStars;
    @SchemaType(example = "OELK", description = "Merchant Types", required = false)
    private Set<String> merchantTypes;
    @SchemaType(description = "Merchant features", required = false)
    private Set<MerchantFeatureResponse> features = new HashSet<>();

}
