/*
 * @author : Oguz Kahraman
 * @since : 12.09.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.models.requests.user;

import com.dota.tamirguru.validators.Password;
import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@Schema(description = "Password change request")
public class ChangePasswordRequest {

    @NotBlank
    @Length(min = 8)
    @Password
    @SchemaType(example = "Ab12@.135", description = "New password of user")
    private String newPassword;

    @NotBlank
    @Length(min = 8)
    @Password
    @SchemaType(example = "Ab12@.135", description = "Old Password of user")
    private String oldPassword;

}
