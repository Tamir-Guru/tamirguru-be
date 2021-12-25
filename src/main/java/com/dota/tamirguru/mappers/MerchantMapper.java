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
import com.dota.tamirguru.entitites.MerchantFeature;
import com.dota.tamirguru.models.requests.merchant.FeatureSet;
import com.dota.tamirguru.models.requests.merchant.MerchantCreateRequest;
import com.dota.tamirguru.models.requests.merchant.MerchantFeatureRequest;
import com.dota.tamirguru.models.responses.merchant.FeatureSetResponse;
import com.dota.tamirguru.models.responses.merchant.FeatureValue;
import com.dota.tamirguru.models.responses.merchant.MerchantFeatureResponse;
import com.dota.tamirguru.models.responses.merchant.MerchantResponse;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

@Mapper(componentModel = "spring")
public interface MerchantMapper {

    @Mapping(target = "name", source = "merchantName")
    @Mapping(target = "address", source = "fullAddress")
    @Mapping(target = "district.id", source = "districtId")
    @Mapping(ignore = true, target = "features")
    Merchant mapRequestToEntity(MerchantCreateRequest request);

    @Mapping(target = "merchantName", source = "name")
    @Mapping(target = "fullAddress", source = "address")
    @Mapping(target = "countryPhoneCode", source = "district.city.country.phoneCode")
    @Mapping(target = "features", ignore = true)
    MerchantResponse mapEntityToResponse(Merchant entity);

    List<MerchantResponse> mapEntityListToResponseList(List<Merchant> entity);

    @AfterMapping
    default void afterRequestToEntity(@MappingTarget Merchant entity, MerchantCreateRequest request) {
        Set<MerchantFeatureRequest> merchantFeatureRequests = request.getMerchantFeatures();
        if (merchantFeatureRequests != null) {
            String[] merchantTypes = merchantFeatureRequests.stream().map(MerchantFeatureRequest::getMerchantTypes)
                    .toArray(String[]::new);
            entity.setMerchantTypes(merchantTypes);
            for (MerchantFeatureRequest featureRequest : merchantFeatureRequests) {
                if (featureRequest.getFeatureSet() != null) {
                    List<MerchantFeature> merchantFeatureList = new ArrayList<>();
                    for (FeatureSet set : featureRequest.getFeatureSet()) {
                        MerchantFeature feature = new MerchantFeature();
                        feature.setValues(new ArrayList<>(set.getValues()));
                        feature.setType(set.getFeature());
                        feature.setTypeId(featureRequest.getMerchantTypes());
                        merchantFeatureList.add(feature);
                    }
                    entity.getFeatures().addAll(merchantFeatureList);
                }
            }
        }
    }

    @AfterMapping
    default void afterEntityToResponseMap(@MappingTarget MerchantResponse response, Merchant entity) {
        response.setCountryName(Translator.getMessage(LocationConstant.COUNTRY_PREFIX + entity.getDistrict().getCity().getCountry().getCode()));
        response.setCityName(Translator.getMessage(LocationConstant.CITY_PREFIX + entity.getDistrict().getCity().getCityCode()));
        response.setDistrictName(Translator.getMessage(LocationConstant.DISTRICT_PREFIX + entity.getDistrict().getId()));
        Map<String, List<MerchantFeature>> featureMap = entity.getFeatures().stream().collect(groupingBy(MerchantFeature::getTypeId));
        for (Map.Entry<String, List<MerchantFeature>> entry : featureMap.entrySet()) {
            MerchantFeatureResponse response1 = new MerchantFeatureResponse();
            response1.setMerchantTypeId(entry.getKey());
            response1.setMerchantType(Translator.getMessage(LocationConstant.MERCHANT_PREFIX + entry.getKey()));
            for (MerchantFeature feature : entry.getValue()) {
                FeatureSetResponse response2 = new FeatureSetResponse();
                response2.setFeature(feature.getType());
                for (Long value : feature.getValues()) {
                    FeatureValue featureValue = new FeatureValue();
                    featureValue.setValue(value);
                    featureValue.setName(Translator.getMessage(LocationConstant.CAR_BRAND_PREFIX + value));
                    response2.getValues().add(featureValue);
                }
                response1.getFeatureSet().add(response2);
            }
            response.getFeatures().add(response1);
        }
        response.setMerchantTypes(new HashSet<>(Arrays.asList(entity.getMerchantTypes())));
    }

}
