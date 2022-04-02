/*
 * @author : Oguz Kahraman
 * @since : 2.04.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.models.responses.comment;

import com.dota.tamirguru.models.responses.merchant.MerchantResponse;
import com.dota.tamirguru.models.responses.user.UserResponse;
import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(description = "Comment Detail Response")
public class CommentResponse {

    @SchemaType(example = "Example", description = "Comment text", required = false)
    private String comment;
    @SchemaType(example = "2020-01-01", description = "Comment date", required = false)
    private LocalDate date;
    @SchemaType(description = "Commenter user id", required = false)
    private UserResponse user;
    @SchemaType(description = "Commented merchant", required = false)
    private MerchantResponse merchant;
    @SchemaType(description = "Positive feedbacks", required = false)
    private Long positive;
    @SchemaType(description = "Negative feedbacks", required = false)
    private Long negative;

}
