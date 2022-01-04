/*
 * @author : Oguz Kahraman
 * @since : 12.09.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.models.requests.user;

import com.dota.tamirguru.validators.Password;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ResetPasswordRequest {

    @NotBlank
    @Email(message = "{email.not.valid}")
    private String email;

    @NotBlank
    @Length(min = 8)
    @Password
    private String password;

    @NotNull
    @Length(min = 50, max = 50)
    private String code;

}
