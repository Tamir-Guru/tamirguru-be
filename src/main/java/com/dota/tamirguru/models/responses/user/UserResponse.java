/*
 * @author : Oguz Kahraman
 * @since : 28.07.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.models.responses.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserResponse {

    @Schema(description = "Email of user", example = "test@test.com")
    private String email;

    @Schema(description = "Name of user", example = "Name Surname")
    private String name;

    @Schema(description = "Surname of user", example = "Name Surname")
    private String surname;

    @Schema(description = "Roles Of User", example = "USER")
    private String role;

    @Schema(description = "JWT token of user", example = "Bearer aksdkasjdjalkdjklajldkjaldjasd")
    private String token;

    @Schema(description = "If user verified", example = "true")
    private Boolean verified;

}
