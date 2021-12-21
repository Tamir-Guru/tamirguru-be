/*
 * @author : Oguz Kahraman
 * @since : 12.09.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.models.requests.user;

import com.dota.tamirguru.validators.Password;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class ChangePasswordRequest {

    @Schema(description = "New password of user", example = "aB123@.123", required = true)
    @NotBlank
    @Length(min = 8)
    @Password
    private String newPassword;

    @Schema(description = "Old password of user", example = "aB123@.123", required = true)
    @NotBlank
    @Length(min = 8)
    @Password
    private String oldPassword;

}
