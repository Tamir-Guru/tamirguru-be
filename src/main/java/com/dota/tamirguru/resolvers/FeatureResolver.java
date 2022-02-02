/*
 * @author : Oguz Kahraman
 * @since : 3.02.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.resolvers;

import com.dota.tamirguru.models.responses.features.FeatureResponse;
import com.dota.tamirguru.services.MerchantFeatureService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeatureResolver implements GraphQLQueryResolver {

    @Autowired
    private MerchantFeatureService merchantFeatureService;

    public List<FeatureResponse> getFeaturesByCategory(String category) {
        return merchantFeatureService.getFeaturesByCategory(category);
    }


}
