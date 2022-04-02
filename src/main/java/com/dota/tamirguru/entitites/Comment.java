/*
 * @author : Oguz Kahraman
 * @since : 2.04.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.entitites;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "comments")
@Entity
@EqualsAndHashCode(callSuper = true)
public class Comment extends BaseEntity {

    @Column(name = "comment")
    private String text;
    private LocalDateTime date = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "merchant_id", insertable = false, updatable = false)
    private Merchant merchant;

    private Long positive = 0L;
    private Long negative = 0L;
    private boolean approved = Boolean.FALSE;

}
