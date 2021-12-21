/*
 * @author : Oguz Kahraman
 * @since : 5.09.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.controllers.impl;

import com.dota.tamirguru.controllers.ValidationController;
import com.dota.tamirguru.models.requests.user.ValidationRequest;
import com.dota.tamirguru.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ValidationControllerImpl implements ValidationController {

    @Autowired
    private ValidationService validationService;

    @Override
    public ResponseEntity<Void> verifyMail(@Valid ValidationRequest request) {
        validationService.verifyMail(request);
        return ResponseEntity.noContent().build();
    }

}
