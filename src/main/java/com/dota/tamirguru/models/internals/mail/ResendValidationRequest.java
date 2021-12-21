/*
 * @author : Oguz Kahraman
 * @since : 13.09.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.models.internals.mail;

import com.dota.tamirguru.enums.ValidationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResendValidationRequest {

    private String mail;
    private ValidationType type;

}
