/*
 * @author : Oguz Kahraman
 * @since : 18.02.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.mappers;

import com.dota.tamirguru.entitites.Comment;
import com.dota.tamirguru.models.requests.comment.CreateCommentRequest;
import com.dota.tamirguru.models.responses.comment.CommentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {UserMapper.class, MerchantMapper.class})
public interface CommentMapper {

    @Mapping(source = "text", target = "comment")
    CommentResponse mapEntityToResponse(Comment comment);

    List<CommentResponse> mapCommentList(List<Comment> comments);

    @Mapping(target = "text", source = "comment")
    @Mapping(target = "merchant.id", source = "merchantId")
    Comment mapToEntity(CreateCommentRequest commentRequest);

}
