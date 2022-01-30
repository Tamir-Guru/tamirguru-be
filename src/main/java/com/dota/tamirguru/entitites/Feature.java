/*
 * @author : Oguz Kahraman
 * @since : 30 Oca 2022
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.entitites;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "features")
@Entity
@TypeDef(name = "string-array", typeClass = StringArrayType.class)
public class Feature {

    @Id
    private String name;
    private String cacheName;
    @Type(type = "string-array")
    private String[] categoryIds;
    private String location;

}
