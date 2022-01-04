/*
 * @author : Oguz Kahraman
 * @since : 28.07.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.models.responses.user;

import lombok.Data;

@Data
public class UserResponse {

    private String email;
    private String name;
    private String surname;
    private String role;
    private String token;
    private Boolean verified;

}
