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
@Table(name = "districts")
@Entity
@EqualsAndHashCode(callSuper = true)
public class District extends BaseEntity {

    private String cityId;
    private String regionId;
    private String name;
    private String language;

}
