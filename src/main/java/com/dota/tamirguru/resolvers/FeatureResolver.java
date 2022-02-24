/*
 * @author : Oguz Kahraman
 * @since : 3.02.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.resolvers;

import com.dota.tamirguru.core.i18n.Translator;
import com.dota.tamirguru.models.responses.features.BrandDetails;
import com.dota.tamirguru.models.responses.features.FeatureResponse;
import com.dota.tamirguru.services.BrandService;
import com.dota.tamirguru.services.MerchantFeatureService;
import com.hero.graphqldoc.annotations.GraphQLDocDetail;
import com.hero.graphqldoc.annotations.ParameterType;
import com.hero.graphqldoc.annotations.QueryType;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@QueryType(description = "Feature Query Operations", key = "Feature Query")
public class FeatureResolver implements GraphQLQueryResolver {

    @Autowired
    private MerchantFeatureService merchantFeatureService;

    @Autowired
    private BrandService brandService;

    @GraphQLDocDetail(operation = "Get features of category", description = "This endpoint returns selectable features by category id")
    public List<FeatureResponse> getFeaturesByCategory(@ParameterType(example = "OELK") String category) {
        return merchantFeatureService.getFeaturesByCategory(category, Translator.getLanguageUpper());
    }

    @GraphQLDocDetail(operation = "Get features deatils", description = "This endpoint returns feature details by feature id")
    public List<BrandDetails> getBrandDetails(@ParameterType(example = "CAR_BRAND") String featureId) {
        return brandService.getBrandDetails(featureId);
    }

}
