/*
 * @author : Oguz Kahraman
 * @since : 5.09.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.models.internals.mail;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MailValidation {

    private String templateName;
    private String header;

}
