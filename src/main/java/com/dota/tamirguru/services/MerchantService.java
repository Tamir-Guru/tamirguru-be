/*
 * @author : Oguz Kahraman
 * @since : 23 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.services;

import com.dota.tamirguru.models.internals.merchant.MerchantTypeName;
import com.dota.tamirguru.models.requests.merchant.MerchantCreateRequest;
import com.dota.tamirguru.models.requests.merchant.MerchantFilter;
import com.dota.tamirguru.models.responses.merchant.MerchantResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface MerchantService {

    List<MerchantTypeName> getMerchants(String language);

    Set<String> getMerchantMap();

    MerchantResponse getMerchantFromId(Long id);

    Long saveMerchant(MerchantCreateRequest request);

    List<MerchantResponse> getMerchantByDistrict(MerchantFilter filter, Pageable pageable);
}
