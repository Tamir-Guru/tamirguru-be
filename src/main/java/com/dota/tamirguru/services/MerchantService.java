/*
 * @author : Oguz Kahraman
 * @since : 23 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.services;

import com.dota.tamirguru.models.requests.merchant.MerchantCreateRequest;
import com.dota.tamirguru.models.requests.merchant.MerchantFilter;
import com.dota.tamirguru.models.responses.merchant.MerchantFeatureResponse;
import com.dota.tamirguru.models.responses.merchant.MerchantResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface MerchantService {

    Set<String> getMerchantMap();

    MerchantResponse saveMerchant(MerchantCreateRequest request);

    List<MerchantResponse> getMerchantByDistrict(MerchantFilter filter, Pageable pageable);

    MerchantResponse findById(Long id);

    Set<MerchantFeatureResponse> findFeaturesById(Long id);
}
