/*
 * @author : Oguz Kahraman
 * @since : 12.09.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.models.requests.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class ResetPasswordMailRequest {

    @NotBlank
    @Email(message = "{email.not.valid}")
    private String email;

}
