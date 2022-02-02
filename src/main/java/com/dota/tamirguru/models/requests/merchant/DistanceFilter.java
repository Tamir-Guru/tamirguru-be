/*
 * @author : Oguz Kahraman
 * @since : 2.02.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.models.requests.merchant;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DistanceFilter {

    @NotNull
    private Double longitude;

    @NotNull
    private Double latitude;

    @NotNull
    private Long distance;

}
