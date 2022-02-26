package com.dota.tamirguru.models.requests.user;

import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Schema(description = "User update request")
public class UserUpdateRequest {

    @NotBlank
    @SchemaType(example = "Example", description = "Name of user")
    private String name;

    @NotBlank
    @SchemaType(example = "Example", description = "Surname of user")
    private String surname;

    @Email(message = "{email.not.valid}")
    @SchemaType(example = "example@example.com", description = "Mail of user")
    private String email;

}
