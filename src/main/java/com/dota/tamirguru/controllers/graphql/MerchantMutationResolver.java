/*
 * @author : Oguz Kahraman
 * @since : 31 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.controllers.graphql;

import com.dota.tamirguru.models.requests.merchant.MerchantCreateRequest;
import com.dota.tamirguru.models.responses.merchant.MerchantResponse;
import com.dota.tamirguru.services.MerchantService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Component
@Validated
public class MerchantMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private MerchantService merchantService;

    @PreAuthorize("isAuthenticated()")
    public MerchantResponse createMerchant(@Valid MerchantCreateRequest request) {
        return merchantService.saveMerchant(request);
    }

}
