/*
 * @author : Oguz Kahraman
 * @since : 13.09.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.models.requests.user;

import com.dota.tamirguru.enums.ValidationType;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ResendVerificationMailRequest {

    @NotBlank
    @Email(message = "{email.not.valid}")
    private String email;

    @NotNull
    private ValidationType type;

}
