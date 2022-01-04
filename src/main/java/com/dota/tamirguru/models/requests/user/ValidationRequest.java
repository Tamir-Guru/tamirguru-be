/*
 * @author : Oguz Kahraman
 * @since : 10.04.2021
 *
 * Copyright - Tamir Guru Java API
 **/
package com.dota.tamirguru.models.requests.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationRequest {

    @NotNull
    @Length(min = 50, max = 50)
    private String code;

    @Email
    private String mail;

}
