/*
 * @author : Oguz Kahraman
 * @since : 2.04.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.repositories;


import com.dota.tamirguru.entitites.Comment;
import com.dota.tamirguru.entitites.Static;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

@SuppressWarnings("java:S100")
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

    List<Comment> findAllByMerchant_IdAndApprovedIsTrue(Long merchantId, Pageable pageable);

    List<Comment> findAllByUser_IdAndApprovedIsTrue(Long userId, Pageable pageable);

    @Query(value = "select avg(c.stars) as avg, count(*) as total from comments c where c.merchant_id = :id", nativeQuery = true)
    Static getStatistic(Long id);

}
