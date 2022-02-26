/*
 * @author : Oguz Kahraman
 * @since : 11.02.2021
 *
 * Copyright - restapi
 **/
package com.dota.tamirguru.models.requests.user;

import com.dota.tamirguru.enums.RoleEnum;
import com.dota.tamirguru.validators.Password;
import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Schema(description = "User create request")
public class UserCreateRequest {

    @NotBlank
    @SchemaType(example = "Example", description = "Name of user")
    private String name;

    @NotBlank
    @SchemaType(example = "Surname", description = "Surname of user")
    private String surname;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @SchemaType(example = "1994-03-16", description = "Birthday of user", required = false)
    private LocalDate birthdate;

    @NotBlank
    @Email(message = "{email.not.valid}")
    @SchemaType(example = "example@example.com", description = "Email of user")
    private String email;

    @Length(min = 11, max = 11)
    @SchemaType(example = "11111111111", description = "Tckn of user", required = false)
    private String tckn;

    @NotBlank
    @Length(min = 8)
    @Password
    @SchemaType(example = "Ab12@.135", description = "Password of user")
    private String password;

    @NotNull
    @SchemaType(example = "INDIVIDUAL", description = "User role")
    private RoleEnum role;

}
