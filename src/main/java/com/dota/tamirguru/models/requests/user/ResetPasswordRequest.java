/*
 * @author : Oguz Kahraman
 * @since : 12.09.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.models.requests.user;

import com.dota.tamirguru.validators.Password;
import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Schema(description = "Password Reset")
public class ResetPasswordRequest {

    @NotBlank
    @Email(message = "{email.not.valid}")
    @SchemaType(example = "example@example.com", description = "User mail")
    private String email;

    @NotBlank
    @Length(min = 8)
    @Password
    @SchemaType(example = "Ab12@.135", description = "Password of user")
    private String password;

    @NotNull
    @Length(min = 50, max = 50)
    @SchemaType(example = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", description = "Reset password code")
    private String code;

}
