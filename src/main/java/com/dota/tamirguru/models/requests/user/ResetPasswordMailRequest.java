/*
 * @author : Oguz Kahraman
 * @since : 12.09.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.models.requests.user;

import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Schema(description = "Request Password Reset Mail")
public class ResetPasswordMailRequest {

    @NotBlank
    @Email(message = "{email.not.valid}")
    @SchemaType(example = "example@example.com", description = "User mail")
    private String email;

}
