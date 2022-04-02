/*
 * @author : Oguz Kahraman
 * @since : 2.04.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.services;

import com.dota.tamirguru.models.responses.comment.CommentResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {

    List<CommentResponse> getUserComments(Long userId, Pageable pageable);
}