/*
 * @author : Oguz Kahraman
 * @since : 21 Ara 2021
 * <p>
 * Copyright - TamirGuru
 **/
package com.dota.tamirguru.services;

import com.dota.tamirguru.entitites.City;
import com.dota.tamirguru.entitites.Country;
import com.dota.tamirguru.entitites.District;

import java.util.List;

public interface LocationService {

    List<Country> getCountries(String language);

    List<City> getCities(String language, String countryCode);

    List<District> getDistricts(String language, String cityId);

}
