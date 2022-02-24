/*
 * @author : Oguz Kahraman
 * @since : 11.02.2021
 *
 * Copyright - restapi
 **/
package com.dota.tamirguru.models.requests.user;

import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Schema(description = "Request of Authentication")
public class AuthRequest {

    @NotEmpty
    @Email
    @SchemaType(example = "example@example.com", description = "Username of the user")
    private String username;

    @NotBlank
    @SchemaType(example = "Ab12@.135", description = "Password of user")
    private String password;

}
