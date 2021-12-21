/*
 * @author : Oguz Kahraman
 * @since : 28.02.2021
 *
 * Copyright - Collige Java API
 **/
package com.io.collige.entitites;

import com.io.collige.enums.ValidationType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "validations")
@Getter
@Setter
public class Validation implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String mail;
    private String code;
    @Enumerated(EnumType.STRING)
    private ValidationType type;
    private LocalDateTime date = LocalDateTime.now();

}
