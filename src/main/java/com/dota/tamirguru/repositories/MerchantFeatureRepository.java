/*
 * @author : Oguz Kahraman
 * @since : 23 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.repositories;

import com.dota.tamirguru.entitites.MerchantFeature;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantFeatureRepository extends CrudRepository<MerchantFeature, Long> {

    @Query(value = "select * from merchant_features where merchant_id = :merchantId", nativeQuery = true)
    List<MerchantFeature> findByMerchantId(Long merchantId);

}
