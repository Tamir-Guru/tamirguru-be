/*
 * @author : Oguz Kahraman
 * @since : 28.02.2021
 *
 * Copyright - Tamir Guru Java API
 **/
package com.dota.tamirguru.entitites;

import com.dota.tamirguru.enums.ValidationType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "validations")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Validation extends BaseEntity {

    private Long userId;
    private String mail;
    private String code;
    @Enumerated(EnumType.STRING)
    private ValidationType type;
    private LocalDateTime date = LocalDateTime.now();

}
