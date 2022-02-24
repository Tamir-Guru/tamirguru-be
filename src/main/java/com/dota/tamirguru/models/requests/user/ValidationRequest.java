/*
 * @author : Oguz Kahraman
 * @since : 10.04.2021
 *
 * Copyright - Tamir Guru Java API
 **/
package com.dota.tamirguru.models.requests.user;

import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Validaton Request")
public class ValidationRequest {

    @NotNull
    @Length(min = 50, max = 50)
    @SchemaType(example = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", description = "Reset password code")
    private String code;

    @Email
    @SchemaType(example = "example@example.com", description = "User mail")
    private String mail;

}
