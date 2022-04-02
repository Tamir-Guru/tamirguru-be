/*
 * @author : Oguz Kahraman
 * @since : 23 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.repositories;

import com.dota.tamirguru.entitites.Merchant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MerchantRepository extends PagingAndSortingRepository<Merchant, Long>, MerchantRepositoryCustom {

    Optional<Merchant> findByIdAndUserId(Long id, Long userId);

    @Query(value = "SELECT * FROM merchants where approved = false", nativeQuery = true)
    List<Merchant> findUnapprovedMerchants();

}
