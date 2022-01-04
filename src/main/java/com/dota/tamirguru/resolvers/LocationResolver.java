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
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocationResolver implements GraphQLQueryResolver {

    @Autowired
    private LocationService locationService;

    public List<CountryResponse> getCountries() {
        return locationService.getCountries(Translator.getLanguageUpper());
    }

    public List<CityResponse> getCities(String countryCode) {
        return locationService.getCities(Translator.getDefaultLanguageUpper(), countryCode);
    }

    public List<DistrictResponse> getDistricts(String cityId) {
        return locationService.getDistricts(Translator.getDefaultLanguageUpper(), cityId);
    }

}
