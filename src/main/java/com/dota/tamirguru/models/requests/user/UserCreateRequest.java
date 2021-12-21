/*
 * @author : Oguz Kahraman
 * @since : 11.02.2021
 *
 * Copyright - restapi
 **/
package com.dota.tamirguru.models.requests.user;

import com.dota.tamirguru.enums.RoleEnum;
import com.dota.tamirguru.validators.Password;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class UserCreateRequest {

    @Schema(description = "Name of user", example = "example", required = true)
    @NotBlank
    private String name;

    @Schema(description = "Surname of user", example = "example", required = true)
    @NotBlank
    private String surname;

    @Schema(description = "Birthdate of user", implementation = LocalDate.class, required = true)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull
    private LocalDate birthdate;

    @Schema(description = "Email of user", example = "test@test.com", required = true)
    @NotBlank
    @Email(message = "{email.not.valid}")
    private String email;

    @Schema(description = "Tckn of user", example = "00000000000")
    @Length(min = 11, max = 11)
    private String tckn;

    @Schema(description = "Password of user", example = "aB123@.123", required = true)
    @NotBlank
    @Length(min = 8)
    @Password
    private String password;

    @Schema(description = "Role of user", example = "INDIVIDUAL", required = true)
    @NotNull
    private RoleEnum role;

}
