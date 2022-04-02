/*
 * @author : Oguz Kahraman
 * @since : 2.04.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.services.impl;

import com.dota.tamirguru.core.security.jwt.JWTService;
import com.dota.tamirguru.entitites.Comment;
import com.dota.tamirguru.mappers.CommentMapper;
import com.dota.tamirguru.models.requests.comment.CreateCommentRequest;
import com.dota.tamirguru.models.responses.comment.CommentResponse;
import com.dota.tamirguru.repositories.CommentRepository;
import com.dota.tamirguru.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void addComment(CreateCommentRequest request) {
        Comment comment = commentMapper.mapToEntity(request);
        comment.setUser(jwtService.getLoggedUser());
        commentRepository.save(comment);
    }

    @Override
    public List<CommentResponse> getUserComments(Long userId, Pageable pageable) {
        return commentMapper.mapCommentList(commentRepository.findAllByUser_IdAndApprovedIsTrue(userId, pageable));
    }

    @Override
    public List<CommentResponse> getUserComments(Pageable pageable) {
        return commentMapper.mapCommentList(commentRepository.findAllByUser_IdAndApprovedIsTrue(jwtService.getLoggedUser().getId(), pageable));
    }

    @Override
    public List<CommentResponse> getMerchantComments(Long merchantId, Pageable pageable) {
        return commentMapper.mapCommentList(commentRepository.findAllByMerchant_IdAndApprovedIsTrue(merchantId, pageable));
    }

}
