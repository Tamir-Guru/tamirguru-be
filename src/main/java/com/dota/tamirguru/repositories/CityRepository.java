
/*
 * @author : Oguz Kahraman
 * @since : 3.08.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.repositories;

import com.dota.tamirguru.entitites.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CityRepository extends CrudRepository<City, Long> {

    @Query("SELECT DISTINCT c.cityName FROM City c order by c.cityName")
    List<String> getCities();

    @Query("SELECT DISTINCT c.district FROM City c where c.cityName = :cityName order by c.district")
    List<String> getDistricts(String cityName);

}
