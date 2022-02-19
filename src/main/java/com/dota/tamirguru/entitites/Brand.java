/*
 * @author : Oguz Kahraman
 * @since : 30 Oca 2022
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.entitites;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "brands")
@Entity
@EqualsAndHashCode(callSuper = true)
public class Brand extends BaseEntity {

    private String name;
    private String featureType;
    private String location;

}
