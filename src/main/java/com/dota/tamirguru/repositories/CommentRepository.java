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

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

    List<Comment> findAllByMerchantIdAndApprovedIsTrue(Long merchantId, Pageable pageable);

    List<Comment> findAllByUserIdAndApprovedTrue(Long userId, Pageable pageable);

}
