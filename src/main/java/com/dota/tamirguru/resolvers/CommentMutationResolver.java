/*
 * @author : Oguz Kahraman
 * @since : 2.04.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.resolvers;

import com.dota.tamirguru.models.requests.comment.CreateCommentRequest;
import com.dota.tamirguru.services.CommentService;
import com.hero.graphqldoc.annotations.GraphQLDocDetail;
import com.hero.graphqldoc.annotations.MutationType;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
@MutationType(description = "Comment Mutation Operations", key = "Comment Mutation")
public class CommentMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private CommentService commentService;

    @GraphQLDocDetail(operation = "Add comments to Merchant", description = "This endpoint adds new comments for merchant")
    @PreAuthorize("isAuthenticated()")
    public Boolean createComment(CreateCommentRequest request) {
        commentService.addComment(request);
        return true;
    }

}
