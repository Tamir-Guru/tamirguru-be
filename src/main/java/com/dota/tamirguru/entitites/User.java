/*
 * @author : Oguz Kahraman
 * @since : 3.08.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.entitites;

import com.dota.tamirguru.enums.RoleEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;


@Getter
@Setter
@Table(name = "users")
@Entity
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    private String name;
    private String surname;
    private String email;
    private String tckn;
    private LocalDate birthdate;
    private String password;
    private boolean verified;
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

}
