/*
 * @author : Oguz Kahraman
 * @since : 21 Ara 2021
 * <p>
 * Copyright - TamirGuru
 **/
package com.dota.tamirguru.services;

import java.util.List;

public interface CityService {

    List<String> getCities();

    List<String> getDistricts(String cityName);

}
