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
import com.hero.graphqldoc.annotations.GraphQLDocDetail;
import com.hero.graphqldoc.annotations.MutationType;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Component
@Validated
@MutationType(description = "User Mutation Operations", key = "User Mutations")
public class UserMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private UserService userService;

    @GraphQLDocDetail(operation = "Create User", description = "This endpoint creates user and returns details")
    public UserResponse createUser(@Valid UserCreateRequest request) {
        if (RoleEnum.COMMERCIAL.equals(request.getRole()) && StringUtils.isBlank(request.getTckn())) {
            throw new GuruException(HttpStatus.BAD_REQUEST, "TCKN can not be null for merchants", "TCKN_NULL");
        }
        return userService.createUser(request);
    }

    @PreAuthorize("isAuthenticated()")
    @GraphQLDocDetail(operation = "Update User", description = "This endpoint updates user and returns details")
    public UserResponse updateUser(@Valid UserUpdateRequest request) {
        return userService.updateUser(request);
    }

    @PreAuthorize("isAuthenticated()")
    @GraphQLDocDetail(operation = "Change User Password", description = "This endpoint changes user password")
    public Boolean changePassword(@Valid ChangePasswordRequest request) {
        userService.changePassword(request);
        return true;
    }

    @GraphQLDocDetail(operation = "Send password reset request", description = "This endpoint sends password reset email")
    public Boolean resetPasswordMail(@Valid ResetPasswordMailRequest request) {
        userService.resetPasswordRequest(request);
        return true;
    }

    @GraphQLDocDetail(operation = "Reset password", description = "This endpoint resets user passsword")
    public Boolean resetPassword(@Valid ResetPasswordRequest request) {
        userService.resetPassword(request);
        return true;
    }

    @GraphQLDocDetail(operation = "Resend verification mail", description = "This endpoint resend verification mail user validation or reset password")
    public Boolean resendVerification(@Valid ResendVerificationMailRequest request) {
        userService.resendValidationMail(request);
        return true;
    }

}
