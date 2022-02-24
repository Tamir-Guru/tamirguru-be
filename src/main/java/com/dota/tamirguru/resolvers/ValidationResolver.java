/*
 * @author : Oguz Kahraman
 * @since : 4 Oca 2022
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.resolvers;

import com.dota.tamirguru.models.requests.user.ValidationRequest;
import com.dota.tamirguru.services.ValidationService;
import com.hero.graphqldoc.annotations.GraphQLDocDetail;
import com.hero.graphqldoc.annotations.QueryType;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Component
@Validated
@QueryType(description = "Validation Query Operations", key = "Validation Query")
public class ValidationResolver implements GraphQLQueryResolver {

    @Autowired
    private ValidationService validationService;

    @GraphQLDocDetail(operation = "Verify User Mail", description = "This endpoint verify user by mail and code")
    public Boolean verifyMail(@Valid ValidationRequest request) {
        validationService.verifyMail(request);
        return true;
    }

}
