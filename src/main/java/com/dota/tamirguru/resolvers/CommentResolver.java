/*
 * @author : Oguz Kahraman
 * @since : 2.04.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.resolvers;

import com.dota.tamirguru.models.responses.comment.CommentResponse;
import com.dota.tamirguru.services.CommentService;
import com.hero.graphqldoc.annotations.GraphQLDocDetail;
import com.hero.graphqldoc.annotations.ParameterType;
import com.hero.graphqldoc.annotations.QueryType;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Component
@Validated
@QueryType(description = "Comment Query Operations", key = "Comment Query")
public class CommentResolver implements GraphQLQueryResolver {

    @Autowired
    private CommentService commentService;

    @GraphQLDocDetail(operation = "Search comments of User", description = "This endpoint gets user's comments ")
    public List<CommentResponse> getUserComments(@ParameterType(example = "1") @Min(1) int pageNumber,
                                                 @ParameterType(example = "1") @Min(1) int pageSize,
                                                 @ParameterType(example = "date") String order,
                                                 @ParameterType(example = "1") @NotNull Long userId) {
        return commentService.getUserComments(userId, PageRequest.of(pageNumber - 1, pageSize, Sort.by(order).ascending()));
    }

}
