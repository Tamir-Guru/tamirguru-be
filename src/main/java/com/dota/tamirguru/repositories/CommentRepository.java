/*
 * @author : Oguz Kahraman
 * @since : 2.04.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.repositories;


import com.dota.tamirguru.entitites.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

@SuppressWarnings("java:S100")
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

    List<Comment> findAllByMerchant_IdAndApprovedIsTrue(Long merchantId, Pageable pageable);

    List<Comment> findAllByUser_IdAndApprovedIsTrue(Long userId, Pageable pageable);

}
