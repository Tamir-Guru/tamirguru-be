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
import com.hero.graphqldoc.annotations.GraphQLDocDetail;
import com.hero.graphqldoc.annotations.ParameterType;
import com.hero.graphqldoc.annotations.QueryType;
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
@QueryType(description = "Merchant Query Operations", key = "Merchant Query")
public class MerchantResolver implements GraphQLQueryResolver {

    @Autowired
    private MerchantService merchantService;

    @GraphQLDocDetail(operation = "Search Merchant", description = "This endpoint gets merchant details by filter")
    public List<MerchantResponse> getMerchants(MerchantFilter filter, @ParameterType(example = "1") int pageNumber,
                                               @ParameterType(example = "1") int pageSize) {
        return merchantService.getMerchantByDistrict(filter, PageRequest.of(pageNumber - 1, pageSize, Sort.by("name").ascending()));
    }

    @GraphQLDocDetail(operation = "Get Merchant Details", description = "This endpoint gets merchant details by id")
    public MerchantResponse merchantDetails(Long id) {
        return merchantService.findById(id);
    }

    @GraphQLDocDetail(operation = "Get Merchant Features by merchant ID", description = "This endpoint gets merchant feature details by merchant id")
    public Set<MerchantFeatureResponse> merchantFeatureDetails(@ParameterType(example = "1") Long id) {
        return merchantService.findFeaturesById(id);
    }

}
