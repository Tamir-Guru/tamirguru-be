/*
 * @author : Oguz Kahraman
 * @since : 21 Ara 2021
 * <p>
 * Copyright - TamirGuru
 **/
package com.dota.tamirguru.services;

import com.dota.tamirguru.models.responses.locations.CityResponse;
import com.dota.tamirguru.models.responses.locations.CountryResponse;
import com.dota.tamirguru.models.responses.locations.DistrictResponse;

import java.util.List;

public interface LocationService {

    List<CountryResponse> getCountries(String language);

    List<CityResponse> getCities(String language, String countryCode);

    List<DistrictResponse> getDistricts(String language, String cityId);

    boolean existByDistrictId(Long districtId);

    boolean existByCityCode(String cityCode);
}
