/*
 * @author : Oguz Kahraman
 * @since : 5.09.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.models.internals.mail;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;
import java.util.Set;

@Data
@NoArgsConstructor
public class GenericMailRequest {

    private Set<String> emails;
    private Locale language;
    private String name;
    private String header;
    private String description;
    private String code;

    public GenericMailRequest(Set<String> emails, String name, String code, Locale language) {
        this.emails = emails;
        this.name = name;
        this.code = code;
        this.language = language;
    }
}
