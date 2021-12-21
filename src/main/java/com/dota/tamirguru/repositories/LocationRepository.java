/*
 * @author : Oguz Kahraman
 * @since : 22 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.repositories;

import com.dota.tamirguru.entitites.BaseEntity;
import com.dota.tamirguru.entitites.City;
import com.dota.tamirguru.entitites.Country;
import com.dota.tamirguru.entitites.District;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository<T extends BaseEntity> extends CrudRepository<T, Long> {

    @Query("select c from Country c where c.language = :language")
    List<Country> getCountryList(String language);

    @Query("select c from City c where c.language = :language and c.countryCode = :countryCode")
    List<City> getCityList(String language, String countryCode);

    @Query("select d from District d where d.language = :language and d.cityId = :cityId")
    List<District> getDistrictList(String language, String cityId);

}
