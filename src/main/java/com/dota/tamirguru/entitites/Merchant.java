/*
 * @author : Oguz Kahraman
 * @since : 23 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.entitites;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "merchants")
@Entity
@EqualsAndHashCode(callSuper = true)
@TypeDef(name = "string-array", typeClass = StringArrayType.class)
@Where(clause = "approved='true'")
public class Merchant extends BaseEntity {

    private String name;
    private String phoneNumber;
    private String email;
    private String website;
    private String details;
    private String photo;
    private LocalDate createDate = LocalDate.now();

    @Type(type = "string-array")
    private String[] merchantTypes;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    private District district = new District();

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "merchant_id", nullable = false)
    private List<MerchantFeature> features = new ArrayList<>();

    private Long userId;
    private String address;
    private Double longitude;
    private Double latitude;
    private boolean approved = Boolean.FALSE;

    @Formula("(select avg(c.stars) from comments c where c.merchant_id = id)")
    private double averageStars;

}
