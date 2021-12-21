/**
 * @author : Oguz Kahraman
 * @since : 21 Ara 2021
 * <p>
 * Copyright - fastmeet
 **/
package com.io.collige.core.utils;

import com.io.collige.constants.RoleConstants;
import com.io.collige.enums.RoleEnum;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
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
