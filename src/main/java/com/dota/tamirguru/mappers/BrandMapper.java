/*
 * @author : Oguz Kahraman
 * @since : 18.02.2022
 *
 * Copyright - tamirguru-be
 **/
package com.dota.tamirguru.mappers;

import com.dota.tamirguru.core.i18n.Translator;
import com.dota.tamirguru.entitites.Brand;
import com.dota.tamirguru.models.responses.features.BrandDetails;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    @Mapping(source = "name", target = "brandName")
    @Mapping(target = "brandType", source = "featureType")
    @Mapping(target = "brandDescription", ignore = true)
    BrandDetails mapBrandToBrandDetails(Brand brand);

    List<BrandDetails> mapBrandList(List<Brand> brands);

    @AfterMapping
    default void afterEntityToResponseMap(@MappingTarget BrandDetails response, Brand entity) {
        response.setBrandDescription(Translator.getMessage(entity.getLocation() + entity.getId()));
    }

}
