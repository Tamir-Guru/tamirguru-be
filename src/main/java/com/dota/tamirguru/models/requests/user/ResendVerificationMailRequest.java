/*
 * @author : Oguz Kahraman
 * @since : 13.09.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.models.requests.user;

import com.dota.tamirguru.enums.ValidationType;
import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Schema(description = "Resend Validation Mail")
public class ResendVerificationMailRequest {

    @NotBlank
    @Email(message = "{email.not.valid}")
    @SchemaType(example = "example@example.com", description = "Mail of the user")
    private String email;

    @NotNull
    @SchemaType(example = "EMAIL", description = "Validation Type")
    private ValidationType type;

}
