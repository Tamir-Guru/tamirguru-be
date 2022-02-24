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
import com.hero.graphqldoc.annotations.GraphQLDocDetail;
import com.hero.graphqldoc.annotations.QueryType;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Component
@Validated
@QueryType(description = "User Query Operations", key = "User Query")
public class UserResolver implements GraphQLQueryResolver {

    @Autowired
    private UserService userService;

    @PreAuthorize("isAuthenticated()")
    @GraphQLDocDetail(operation = "Get User Info", description = "This endpoint returns logged in user info")
    public UserResponse getUserDetails() {
        return userService.getUserDetailsFromToken();
    }

    @GraphQLDocDetail(operation = "Login User", description = "This endpoint login user and returns user information")
    public UserResponse login(@Valid AuthRequest request) {
        return userService.loginUser(request);
    }
}
