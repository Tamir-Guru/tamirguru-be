/*
 * @author : Oguz Kahraman
 * @since : 5.09.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.services.impl;

import com.dota.tamirguru.core.exception.GuruException;
import com.dota.tamirguru.core.i18n.Translator;
import com.dota.tamirguru.entitites.User;
import com.dota.tamirguru.entitites.Validation;
import com.dota.tamirguru.enums.ValidationType;
import com.dota.tamirguru.models.internals.mail.ResendValidationRequest;
import com.dota.tamirguru.models.requests.user.ValidationRequest;
import com.dota.tamirguru.repositories.UserRepository;
import com.dota.tamirguru.repositories.ValidationRepository;
import com.dota.tamirguru.services.ValidationService;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ValidationServiceImpl implements ValidationService {

    private static final String VAL_ERR = "VAL_ERR";
    private static final String VALIDATION_NOT_VALID = "validation_not_valid";
    private final RandomStringGenerator pwdGenerator = new RandomStringGenerator.Builder().withinRange('0', 'z')
            .filteredBy(CharacterPredicates.DIGITS, CharacterPredicates.LETTERS)
            .build();

    @Autowired
    private ValidationRepository validationRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * This methods verified user mail
     *
     * @param request verify request detail
     **/
    @Override
    public void verifyMail(ValidationRequest request) {
        Validation validation = validationRepository.findByCodeAndMailAndType(request.getCode(), request.getMail(), ValidationType.EMAIL)
                .orElseThrow(() -> new GuruException(HttpStatus.BAD_REQUEST, Translator.getMessage(VALIDATION_NOT_VALID), VAL_ERR));
        validationRepository.delete(validation);
        userRepository.verifyUserByMail(request.getMail());
    }

    /**
     * This methods verified user mail
     *
     * @param request verify request detail
     **/
    @Override
    public void verify(ValidationRequest request) {
        Validation validation = validationRepository.findByCodeAndMailAndType(request.getCode(), request.getMail(), ValidationType.PASSWORD)
                .orElseThrow(() -> new GuruException(HttpStatus.BAD_REQUEST, Translator.getMessage(VALIDATION_NOT_VALID), VAL_ERR));
        validationRepository.delete(validation);
    }

    /**
     * This methods verified user mail
     *
     * @param request verify request detail
     **/
    @Override
    public Validation getValidationDetail(ResendValidationRequest request) {
        return validationRepository.findByMailAndType(request.getMail(), request.getType())
                .orElseThrow(() -> new GuruException(HttpStatus.BAD_REQUEST, Translator.getMessage(VALIDATION_NOT_VALID), VAL_ERR));
    }

    /**
     * Create new validation information for user
     *
     * @param user details
     * @param type validation type
     **/
    @Override
    public String createValidationInfo(User user, ValidationType type) {
        Validation validation = validationRepository.findByMailAndType(user.getEmail(), ValidationType.EMAIL).orElse(new Validation());
        validation.setUserId(user.getId());
        validation.setCode(pwdGenerator.generate(50));
        validation.setMail(user.getEmail());
        validation.setDate(LocalDateTime.now());
        validation.setType(type);
        validationRepository.save(validation);
        return validation.getCode();
    }

}
