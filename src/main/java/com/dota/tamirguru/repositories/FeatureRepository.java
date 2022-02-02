/*
 * @author : Oguz Kahraman
 * @since : 30 Oca 2022
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.repositories;

import com.dota.tamirguru.entitites.Feature;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeatureRepository extends CrudRepository<Feature, String> {

    @Query(value = "select * from features where ARRAY[:type] && features.category_ids",
            nativeQuery = true)
    List<Feature> getFeaturesFromType(String type);

}
