/*
 * @author : Oguz Kahraman
 * @since : 23 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.repositories;

import com.dota.tamirguru.entitites.MerchantType;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MerchantTypeRepository extends CrudRepository<MerchantType, Long> {

    @Query("select mt.typeId from MerchantType mt")
    @Cacheable(cacheNames = "allMerchantTypes")
    Set<String> findTypes();

}
