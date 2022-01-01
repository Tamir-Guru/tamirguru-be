/*
 * @author : Oguz Kahraman
 * @since : 3.08.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.services;

import com.dota.tamirguru.entitites.User;
import com.dota.tamirguru.models.requests.user.AuthRequest;
import com.dota.tamirguru.models.requests.user.ChangePasswordRequest;
import com.dota.tamirguru.models.requests.user.ResendVerificationMailRequest;
import com.dota.tamirguru.models.requests.user.ResetPasswordMailRequest;
import com.dota.tamirguru.models.requests.user.ResetPasswordRequest;
import com.dota.tamirguru.models.requests.user.UserCreateRequest;
import com.dota.tamirguru.models.requests.user.UserUpdateRequest;
import com.dota.tamirguru.models.responses.user.UserResponse;

public interface UserService {

    UserResponse createUser(UserCreateRequest request);

    UserResponse loginUser(AuthRequest authRequest);

    User getFromUserName(String userName);

    UserResponse findByMail(String email);

    boolean ifUserExist(String email);

    UserResponse getUserDetailsFromToken();

    void resetPasswordRequest(ResetPasswordMailRequest request);

    void resetPassword(ResetPasswordRequest request);

    void changePassword(ChangePasswordRequest request);

    void resendValidationMail(ResendVerificationMailRequest request);

    UserResponse updateUser(UserUpdateRequest userUpdateRequest);

}
