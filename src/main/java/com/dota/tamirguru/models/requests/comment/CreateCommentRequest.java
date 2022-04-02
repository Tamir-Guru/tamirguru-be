/*
 * @author : Oguz Kahraman
 * @since : 2.04.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.models.requests.comment;

import com.hero.graphqldoc.annotations.Schema;
import com.hero.graphqldoc.annotations.SchemaType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Schema(description = "Merchant Filter Request")
public class CreateCommentRequest {

    @NotBlank
    @SchemaType(example = "Example comment", description = "Comment for the merchant")
    private String comment;
    @NotNull
    @SchemaType(example = "1L", description = "Merchant Id")
    private Long merchantId;

}
