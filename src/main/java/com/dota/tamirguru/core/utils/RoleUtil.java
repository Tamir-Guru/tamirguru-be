/*
 * @author : Oguz Kahraman
 * @since : 21 Ara 2021
 * <p>
 * Copyright - TamirGuru
 **/
package com.dota.tamirguru.core.utils;

import com.dota.tamirguru.constants.RoleConstants;
import com.dota.tamirguru.enums.RoleEnum;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoleUtil {

    private static final Set<String> INDIVIDUAL = new HashSet<>();
    private static final Set<String> COMMERCIAL = new HashSet<>();

    static {
        INDIVIDUAL.add(RoleConstants.INDIVIDUAL);
        COMMERCIAL.add(RoleConstants.COMMERCIAL);
    }

    public static Set<String> getRole(RoleEnum role) {
        if (RoleEnum.COMMERCIAL.equals(role)) {
            return COMMERCIAL;
        }
        return INDIVIDUAL;
    }

}
