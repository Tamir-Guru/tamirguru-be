/*
 * @author : Oguz Kahraman
 * @since : 5.09.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.services;

import com.dota.tamirguru.entitites.User;
import com.dota.tamirguru.entitites.Validation;
import com.dota.tamirguru.enums.ValidationType;
import com.dota.tamirguru.models.internals.mail.ResendValidationRequest;
import com.dota.tamirguru.models.requests.user.ValidationRequest;

public interface ValidationService {
    void verifyMail(ValidationRequest request);

    void verify(ValidationRequest request);

    Validation getValidationDetail(ResendValidationRequest request);

    String createValidationInfo(User user, ValidationType type);
}
