/*
 * @author : Oguz Kahraman
 * @since : 18.02.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.mappers;

import com.dota.tamirguru.entitites.Comment;
import com.dota.tamirguru.models.responses.comment.CommentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {UserMapper.class, MerchantMapper.class})
public interface CommentMapper {

    @Mapping(source = "text", target = "comment")
    CommentResponse mapBrandToBrandDetails(Comment brand);

    List<CommentResponse> mapBrandList(List<Comment> brands);

}
