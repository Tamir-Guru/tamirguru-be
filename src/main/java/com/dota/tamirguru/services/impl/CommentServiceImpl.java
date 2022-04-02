/*
 * @author : Oguz Kahraman
 * @since : 2.04.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.services.impl;

import com.dota.tamirguru.mappers.CommentMapper;
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
    private CommentRepository commentRepository;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<CommentResponse> getUserComments(Long userId, Pageable pageable) {
        return commentMapper.mapBrandList(commentRepository.findAllByUserIdAndApprovedTrue(userId, pageable));
    }


}
