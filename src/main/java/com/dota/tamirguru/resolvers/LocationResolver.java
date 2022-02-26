/*
 * @author : Oguz Kahraman
 * @since : 4 Oca 2022
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.resolvers;

import com.dota.tamirguru.core.i18n.Translator;
import com.dota.tamirguru.models.responses.locations.CityResponse;
import com.dota.tamirguru.models.responses.locations.CountryResponse;
import com.dota.tamirguru.models.responses.locations.DistrictResponse;
import com.dota.tamirguru.services.LocationService;
import com.hero.graphqldoc.annotations.GraphQLDocDetail;
import com.hero.graphqldoc.annotations.ParameterType;
import com.hero.graphqldoc.annotations.QueryType;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@QueryType(description = "Location Query Operations", key = "Location Query")
public class LocationResolver implements GraphQLQueryResolver {

    @Autowired
    private LocationService locationService;

    @GraphQLDocDetail(operation = "Get all countries", description = "This endpoint returns country details")
    public List<CountryResponse> getCountries() {
        return locationService.getCountries(Translator.getLanguageUpper());
    }

    @GraphQLDocDetail(operation = "Get cities of country", description = "This endpoint returns city details by country code")
    public List<CityResponse> getCities(@ParameterType(example = "TR") String countryCode) {
        return locationService.getCities(Translator.getDefaultLanguageUpper(), countryCode);
    }

    @GraphQLDocDetail(operation = "Get cities of city", description = "This endpoint returns districts details by city code")
    public List<DistrictResponse> getDistricts(@ParameterType(example = "1") String cityId) {
        return locationService.getDistricts(Translator.getDefaultLanguageUpper(), cityId);
    }

}
