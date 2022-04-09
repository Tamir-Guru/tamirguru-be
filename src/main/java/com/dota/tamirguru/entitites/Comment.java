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
import org.hibernate.annotations.Formula;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Table(name = "comments")
@Entity
@EqualsAndHashCode(callSuper = true)
public class Comment extends BaseEntity {

    @Column(name = "comment")
    private String text;
    private LocalDate date = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    @Formula("(select count(p.*) from votes p where p.comment_id = id and p.is_positive = true)")
    private Long positive = 0L;
    @Formula("(select count(p.*) from votes p where p.comment_id = id and p.is_positive = false)")
    private Long negative = 0L;

    private Short stars = 1;
    private boolean approved = Boolean.FALSE;

}
