/*
 * @author : Oguz Kahraman
 * @since : 4 Oca 2022
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.resolvers;

import com.dota.tamirguru.models.requests.user.ValidationRequest;
import com.dota.tamirguru.services.ValidationService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Component
@Validated
public class ValidationResolver implements GraphQLQueryResolver {

    @Autowired
    private ValidationService validationService;

    public Boolean verifyMail(@Valid ValidationRequest request) {
        validationService.verifyMail(request);
        return true;
    }

}
