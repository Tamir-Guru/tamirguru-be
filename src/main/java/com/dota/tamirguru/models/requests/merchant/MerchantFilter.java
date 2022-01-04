/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.models.requests.merchant;

import com.dota.tamirguru.enums.Feature;
import com.dota.tamirguru.validators.City;
import com.dota.tamirguru.validators.District;
import com.dota.tamirguru.validators.Merchant;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
public class MerchantFilter {

    @Merchant
    private Set<@NotBlank String> types = new HashSet<>();

    private Set<@NotNull @District Long> districts = new HashSet<>();

    private Set<@NotBlank @City String> cities = new HashSet<>();

    private Set<Feature> features = new HashSet<>();

    private Set<Long> values;

}
