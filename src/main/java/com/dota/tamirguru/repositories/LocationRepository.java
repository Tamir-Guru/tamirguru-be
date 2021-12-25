/*
 * @author : Oguz Kahraman
 * @since : 22 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.repositories;

import com.dota.tamirguru.entitites.BaseEntity;
import com.dota.tamirguru.entitites.District;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface LocationRepository<T extends BaseEntity> extends CrudRepository<T, Long> {

    @Query("select distinct(c.code), c.phoneCode from Country c")
    @Cacheable(cacheNames = "allCountries")
    List<Object[]> getCountryList();

    @Query("select distinct(c.cityCode) from City c where c.country.code = :countryCode")
    @Cacheable(cacheNames = "allCities")
    List<String> getCityList(String countryCode);

    @Query("select distinct(d.id) from District d where d.city.cityCode= :cityId")
    @Cacheable(cacheNames = "allDistricts")
    List<String> getDistrictList(String cityId);

    @Query("select distinct(c.cityCode) from City c")
    @Cacheable(cacheNames = "cityCodes")
    Set<String> getCityCodes();

    @Query("select distinct(d.id) from District d")
    @Cacheable(cacheNames = "districtCodes")
    Set<Long> getDistrictCodes();

    @Query("select d from District d where d.id = :id")
    District getDistrictById(Long id);

}
