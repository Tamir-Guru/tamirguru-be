/*
 * @author : Oguz Kahraman
 * @since : 21 Ara 2021
 * <p>
 * Copyright - TamirGuru
 **/
package com.dota.tamirguru.mappers;

import org.apache.commons.text.WordUtils;
import org.mapstruct.Named;

import java.util.Locale;

public interface GenericMapper {

    @Named("capitalize")
    default String capitalize(String text) {
        return WordUtils.capitalizeFully(text);
    }

    @Named("lowercase")
    default String lowercase(String text) {
        return text.toLowerCase(Locale.UK);
    }

}
