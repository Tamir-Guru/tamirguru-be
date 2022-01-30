/*
 * @author : Oguz Kahraman
 * @since : 3.08.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.entitites;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;


@Getter
@Setter
@Table(name = "merchant_features")
@Entity
@EqualsAndHashCode(callSuper = true)
@TypeDef(name = "list-array", typeClass = ListArrayType.class)
public class MerchantFeature extends BaseEntity {

    @Type(type = "list-array")
    private List<Long> values;
    private String typeId;
    private String type;

}

