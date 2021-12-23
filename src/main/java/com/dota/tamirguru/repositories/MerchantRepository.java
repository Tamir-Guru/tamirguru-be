/*
 * @author : Oguz Kahraman
 * @since : 23 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.repositories;

import com.dota.tamirguru.entitites.Merchant;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantRepository extends PagingAndSortingRepository<Merchant, Long> {

    List<Merchant> findByDistrictId(Long id, Pageable pageable);

}
