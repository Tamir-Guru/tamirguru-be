/*
 * @author : Oguz Kahraman
 * @since : 2.04.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.services;

import com.dota.tamirguru.models.requests.comment.CreateCommentRequest;
import com.dota.tamirguru.models.responses.comment.CommentResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {

    void addComment(CreateCommentRequest request);

    List<CommentResponse> getUserComments(Long userId, Pageable pageable);

    List<CommentResponse> getUserComments(Pageable pageable);

    List<CommentResponse> getMerchantComments(Long merchantId, Pageable pageable);

    void addVote(Long commentId, Boolean positive);

    void deleteVote(Long commentId);
}
