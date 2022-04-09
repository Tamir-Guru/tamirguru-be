/*
 * @author : Oguz Kahraman
 * @since : 9.04.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.repositories;

import com.dota.tamirguru.entitites.Vote;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote, Long> {

    int deleteByUserIdAndCommentId(Long userId, Long commentId);

}
