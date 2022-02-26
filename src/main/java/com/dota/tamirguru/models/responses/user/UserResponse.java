/*
 * @author : Oguz Kahraman
 * @since : 28.07.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.models.responses.user;

import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(description = "Response of user details")
public class UserResponse {

    @SchemaType(example = "example@example.com", description = "Email of the user", required = false)
    private String email;
    @SchemaType(example = "Name", description = "Name of the user", required = false)
    private String name;
    @SchemaType(example = "https://www.photo.com", description = "Photo url of the user", required = false)
    private String photo;
    @SchemaType(example = "Surname", description = "Surname of the user", required = false)
    private String surname;
    @SchemaType(example = "MERCHANT", description = "Role of the user", required = false)
    private String role;
    @SchemaType(example = "jaasudgiuyasgdb1;puoe391tegqndlaldbasmdasd", description = "Token of the user", required = false)
    private String token;
    @SchemaType(example = "true", description = "Is the user active", required = false)
    private Boolean verified;
    @SchemaType(example = "2022-10-10", description = "User creation date", required = false)
    private LocalDate createDate;

}
