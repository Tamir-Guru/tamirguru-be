/*
 * @author : Oguz Kahraman
 * @since : 31 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.resolvers;

import com.dota.tamirguru.models.requests.user.AuthRequest;
import com.dota.tamirguru.models.responses.user.UserResponse;
import com.dota.tamirguru.services.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Component
@Validated
public class UserResolver implements GraphQLQueryResolver {

    @Autowired
    private UserService userService;

    @PreAuthorize("isAuthenticated()")
    public UserResponse getUserDetails() {
        return userService.getUserDetailsFromToken();
    }

    public UserResponse login(@Valid AuthRequest request) {
        return userService.loginUser(request);
    }
}
