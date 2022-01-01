/*
 * @author : Oguz Kahraman
 * @since : 11.02.2021
 *
 * Copyright - restapi
 **/
package com.dota.tamirguru.controllers.impl;

import com.dota.tamirguru.controllers.UserController;
import com.dota.tamirguru.models.requests.user.AuthRequest;
import com.dota.tamirguru.models.requests.user.ChangePasswordRequest;
import com.dota.tamirguru.models.requests.user.ResendVerificationMailRequest;
import com.dota.tamirguru.models.requests.user.ResetPasswordMailRequest;
import com.dota.tamirguru.models.requests.user.ResetPasswordRequest;
import com.dota.tamirguru.models.requests.user.UserCreateRequest;
import com.dota.tamirguru.models.requests.user.UserUpdateRequest;
import com.dota.tamirguru.models.responses.user.UserResponse;
import com.dota.tamirguru.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<UserResponse> createUser(@Valid UserCreateRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }

    @Override
    public ResponseEntity<UserResponse> loginUser(@Valid AuthRequest request) {
        return ResponseEntity.ok(userService.loginUser(request));
    }

    @Override
    public ResponseEntity<UserResponse> getDetailsByToken() {
        return ResponseEntity.ok(userService.getUserDetailsFromToken());
    }

    @Override
    public ResponseEntity<Void> changePassword(@Valid ChangePasswordRequest request) {
        userService.changePassword(request);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> resetPasswordRequest(@Valid ResetPasswordMailRequest request) {
        userService.resetPasswordRequest(request);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> resetPassword(@Valid ResetPasswordRequest request) {
        userService.resetPassword(request);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> resendVerification(@Valid ResendVerificationMailRequest request) {
        userService.resendValidationMail(request);
        return ResponseEntity.noContent().build();

    }

    @Override
    public ResponseEntity<UserResponse> updateUser(@Valid UserUpdateRequest request) {
        return ResponseEntity.ok(userService.updateUser(request));
    }

}
