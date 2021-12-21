/**
 * @author : Oguz Kahraman
 * @since : 21 Ara 2021
 * <p>
 * Copyright - fastmeet
 **/
package com.io.collige.services;

import java.util.List;

public interface CityService {

    List<String> getCities();

    List<String> getDistricts(String cityName);

}
