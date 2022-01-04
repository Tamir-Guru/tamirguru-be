package com.dota.tamirguru.models.requests.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserUpdateRequest {

    @NotBlank
    private String name;

    private String picture;

    @NotBlank
    @Email(message = "{email.not.valid}")
    private String email;

    @NotBlank
    private String timeZone;

}
