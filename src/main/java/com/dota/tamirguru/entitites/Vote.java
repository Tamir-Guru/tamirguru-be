/*
 * @author : Oguz Kahraman
 * @since : 9.04.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.entitites;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "votes")
@Entity
@EqualsAndHashCode(callSuper = true)
public class Vote extends BaseEntity {

    private Long commentId;
    private Long userId;
    private boolean isPositive = Boolean.TRUE;

}