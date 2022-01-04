/*
 * @author : Oguz Kahraman
 * @since : 31 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.resolvers;

import com.dota.tamirguru.models.requests.merchant.MerchantFilter;
import com.dota.tamirguru.models.responses.merchant.MerchantFeatureResponse;
import com.dota.tamirguru.models.responses.merchant.MerchantResponse;
import com.dota.tamirguru.services.MerchantService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Set;

@Component
@Validated
public class MerchantResolver implements GraphQLQueryResolver {

    @Autowired
    private MerchantService merchantService;

    public List<MerchantResponse> getMerchants(MerchantFilter filter, int pageNumber, int pageSize) {
        return merchantService.getMerchantByDistrict(filter, PageRequest.of(pageNumber - 1, pageSize, Sort.by("name").ascending()));
    }

    public MerchantResponse merchantDetails(Long id) {
        return merchantService.findById(id);
    }

    public Set<MerchantFeatureResponse> merchantFeatureDetails(Long id) {
        return merchantService.findFeaturesById(id);
    }

}
