/*
 * @author : Oguz Kahraman
 * @since : 11.02.2021
 *
 * Copyright - restapi
 **/
package com.dota.tamirguru.models.requests.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class AuthRequest {

    @NotEmpty
    @Email
    private String username;

    @NotBlank
    private String password;

}
