/*
 * @author : Oguz Kahraman
 * @since : 23 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.services.impl;

import com.dota.tamirguru.constants.LocationConstant;
import com.dota.tamirguru.core.i18n.Translator;
import com.dota.tamirguru.entitites.Merchant;
import com.dota.tamirguru.mappers.MerchantMapper;
import com.dota.tamirguru.models.internals.merchant.MerchantTypeName;
import com.dota.tamirguru.models.requests.merchant.MerchantCreateRequest;
import com.dota.tamirguru.models.responses.merchant.MerchantResponse;
import com.dota.tamirguru.repositories.MerchantRepository;
import com.dota.tamirguru.repositories.MerchantTypeRepository;
import com.dota.tamirguru.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantTypeRepository merchantTypeRepository;

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    @Cacheable(cacheNames = "merchantType")
    public List<MerchantTypeName> getMerchants(String language) {
        List<MerchantTypeName> merchantTypeNames = new ArrayList<>();
        Set<String> allTypes = merchantTypeRepository.findTypes();
        allTypes.forEach(item -> merchantTypeNames
                .add(new MerchantTypeName(Translator.getMessage(LocationConstant.MERCHANT_PREFIX + item), item)));
        return merchantTypeNames;
    }

    @Override
    @Cacheable(cacheNames = "merchantTypeMap")
    public Set<String> getMerchantMap() {
        return merchantTypeRepository.findTypes();
    }

    @Override
    public MerchantResponse saveMerchant(MerchantCreateRequest request) {
        Merchant merchant = merchantMapper.mapRequestToEntity(request);
        merchantRepository.save(merchant);
        return merchantMapper.mapEntityToResponse(merchant);
    }

    @Override
    public List<MerchantResponse> getMerchantByDistrict(Long districtId, Pageable pageable) {
        List<Merchant> merchants = merchantRepository.findByDistrictId(districtId, pageable);
        return merchantMapper.mapEntityListToResponseList(merchants);
    }

}
