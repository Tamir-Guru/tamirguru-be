/*
 * @author : Oguz Kahraman
 * @since : 26.09.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LinkUtil {

    @Value("${system.validation.url}")
    private String validationUrl;

    @Value("${system.validation.url}")
    private String passwordReset;

    @Value("${system.validation.url}")
    private String invitation;

    public String getValidationUrl() {
        return validationUrl;
    }

    public String getPasswordReset() {
        return passwordReset;
    }

    public String getInvitation() {
        return invitation;
    }

}
