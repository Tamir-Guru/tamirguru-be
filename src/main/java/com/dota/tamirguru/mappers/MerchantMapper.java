/*
 * @author : Oguz Kahraman
 * @since : 21 Ara 2021
 * <p>
 * Copyright - TamirGuru
 **/
package com.dota.tamirguru.mappers;

import com.dota.tamirguru.constants.LocationConstant;
import com.dota.tamirguru.core.i18n.Translator;
import com.dota.tamirguru.entitites.Merchant;
import com.dota.tamirguru.models.requests.merchant.MerchantCreateRequest;
import com.dota.tamirguru.models.responses.merchant.MerchantResponse;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MerchantMapper {

    @Mapping(source = "merchantName", target = "name")
    @Mapping(source = "merchantTypeId", target = "merchantType")
    @Mapping(source = "fullAddress", target = "address")
    @Mapping(source = "districtId", target = "district.id")
    Merchant mapRequestToEntity(MerchantCreateRequest request);

    @Mapping(target = "merchantName", source = "name")
    @Mapping(target = "merchantTypeId", source = "merchantType")
    @Mapping(target = "fullAddress", source = "address")
    @Mapping(target = "countryPhoneCode", source = "district.city.country.phoneCode")
    @Mapping(target = "merchantType", ignore = true)
    MerchantResponse mapEntityToResponse(Merchant entity);

    List<MerchantResponse> mapEntityListToResponseList(List<Merchant> entity);

    @AfterMapping
    default void afterEntityToResponseMap(@MappingTarget MerchantResponse response, Merchant entity) {
        response.setCountryName(Translator.getMessage(LocationConstant.COUNTRY_PREFIX + entity.getDistrict().getCity().getCountry().getCode()));
        response.setCityName(Translator.getMessage(LocationConstant.CITY_PREFIX + entity.getDistrict().getCity().getCityCode()));
        response.setMerchantType(Translator.getMessage(LocationConstant.MERCHANT_PREFIX + entity.getMerchantType()));
        response.setDistrictName(Translator.getMessage(LocationConstant.DISTRICT_PREFIX + entity.getDistrict().getId()));
    }

}
