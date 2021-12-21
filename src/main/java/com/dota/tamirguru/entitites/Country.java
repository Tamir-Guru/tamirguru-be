/*
 * @author : Oguz Kahraman
 * @since : 3.08.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.entitites;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@Table(name = "countries")
@Entity
@EqualsAndHashCode(callSuper = true)
public class Country extends BaseEntity {

    private String name;
    private String code;
    private String language;

}
