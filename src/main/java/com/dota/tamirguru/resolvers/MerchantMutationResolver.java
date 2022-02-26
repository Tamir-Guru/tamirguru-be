/*
 * @author : Oguz Kahraman
 * @since : 31 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.resolvers;

import com.dota.tamirguru.models.requests.merchant.MerchantCreateRequest;
import com.dota.tamirguru.models.requests.merchant.MerchantUpdateRequest;
import com.dota.tamirguru.models.responses.merchant.MerchantResponse;
import com.dota.tamirguru.services.MerchantService;
import com.hero.graphqldoc.annotations.GraphQLDocDetail;
import com.hero.graphqldoc.annotations.MutationType;
import com.hero.graphqldoc.annotations.ParameterType;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.servlet.http.Part;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;

@Component
@Validated
@MutationType(description = "Merchant Mutation Operations", key = "Merchant Mutation")
public class MerchantMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private MerchantService merchantService;

    @PreAuthorize("hasRole('ROLE_COMMERCIAL')")
    @GraphQLDocDetail(operation = "Create Merchant", description = "This endpoint creates merchant and returns details")
    public MerchantResponse createMerchant(@Valid MerchantCreateRequest request) {
        return merchantService.saveMerchant(request);
    }

    @PreAuthorize("hasRole('ROLE_COMMERCIAL')")
    @GraphQLDocDetail(operation = "Update Merchant", description = "This endpoint updates merchant and returns details")
    public MerchantResponse updateMerchant(@Valid MerchantUpdateRequest request) {
        return merchantService.saveMerchant(request);
    }

    @PreAuthorize("hasRole('ROLE_COMMERCIAL')")
    @GraphQLDocDetail(operation = "Update Merchant Avatar", description = "This endpoint updates avatar and returns merchant details")
    public MerchantResponse updateMerchantAvatar(Part avatar, @ParameterType(example = "1", description = "Merchant id") @NotNull Long id) throws IOException {
        return merchantService.updateMerchantPhoto(IOUtils.toByteArray(avatar.getInputStream()), id);
    }


}
