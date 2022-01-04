/*
 * @author : Oguz Kahraman
 * @since : 1 Oca 2022
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.resolvers;

import com.dota.tamirguru.core.exception.GuruException;
import com.dota.tamirguru.enums.RoleEnum;
import com.dota.tamirguru.models.requests.user.ChangePasswordRequest;
import com.dota.tamirguru.models.requests.user.ResendVerificationMailRequest;
import com.dota.tamirguru.models.requests.user.ResetPasswordMailRequest;
import com.dota.tamirguru.models.requests.user.ResetPasswordRequest;
import com.dota.tamirguru.models.requests.user.UserCreateRequest;
import com.dota.tamirguru.models.requests.user.UserUpdateRequest;
import com.dota.tamirguru.models.responses.user.UserResponse;
import com.dota.tamirguru.services.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Component
@Validated
public class UserMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private UserService userService;

    public UserResponse createUser(@Valid UserCreateRequest request) {
        if (RoleEnum.COMMERCIAL.equals(request.getRole()) && StringUtils.isBlank(request.getTckn())) {
            throw new GuruException(HttpStatus.BAD_REQUEST, "TCKN can not be null for merchants", "TCKN_NULL");
        }
        return userService.createUser(request);
    }

    public UserResponse updateUser(@Valid UserUpdateRequest request) {
        return userService.updateUser(request);
    }

    public Boolean changePassword(@Valid ChangePasswordRequest request) {
        userService.changePassword(request);
        return true;
    }

    public Boolean resetPasswordMail(@Valid ResetPasswordMailRequest request) {
        userService.resetPasswordRequest(request);
        return true;
    }

    public Boolean resetPassword(@Valid ResetPasswordRequest request) {
        userService.resetPassword(request);
        return true;
    }

    public Boolean resendVerification(@Valid ResendVerificationMailRequest request) {
        userService.resendValidationMail(request);
        return true;
    }

}
