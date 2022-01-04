/*
 * @author : Oguz Kahraman
 * @since : 11.02.2021
 *
 * Copyright - restapi
 **/
package com.dota.tamirguru.models.requests.user;

import com.dota.tamirguru.enums.RoleEnum;
import com.dota.tamirguru.validators.Password;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class UserCreateRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull
    private LocalDate birthdate;

    @NotBlank
    @Email(message = "{email.not.valid}")
    private String email;

    @Length(min = 11, max = 11)
    private String tckn;

    @NotBlank
    @Length(min = 8)
    @Password
    private String password;

    @NotNull
    private RoleEnum role;

}
