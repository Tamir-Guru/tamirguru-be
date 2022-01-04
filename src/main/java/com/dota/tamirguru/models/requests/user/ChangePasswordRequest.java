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

import javax.validation.constraints.NotBlank;

@Data
public class ChangePasswordRequest {

    @NotBlank
    @Length(min = 8)
    @Password
    private String newPassword;

    @NotBlank
    @Length(min = 8)
    @Password
    private String oldPassword;

}
