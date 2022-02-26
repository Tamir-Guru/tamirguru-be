/*
 * @author : Oguz Kahraman
 * @since : 23 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.services.impl;

import com.dota.tamirguru.constants.GeneralMessageConstants;
import com.dota.tamirguru.core.exception.GuruException;
import com.dota.tamirguru.core.security.jwt.JWTService;
import com.dota.tamirguru.entitites.Merchant;
import com.dota.tamirguru.entitites.MerchantType;
import com.dota.tamirguru.entitites.User;
import com.dota.tamirguru.mappers.MerchantMapper;
import com.dota.tamirguru.models.requests.merchant.MerchantCreateRequest;
import com.dota.tamirguru.models.requests.merchant.MerchantFilter;
import com.dota.tamirguru.models.requests.merchant.MerchantUpdateRequest;
import com.dota.tamirguru.models.responses.merchant.MerchantFeatureResponse;
import com.dota.tamirguru.models.responses.merchant.MerchantResponse;
import com.dota.tamirguru.repositories.LocationRepository;
import com.dota.tamirguru.repositories.MerchantFeatureRepository;
import com.dota.tamirguru.repositories.MerchantRepository;
import com.dota.tamirguru.repositories.MerchantTypeRepository;
import com.dota.tamirguru.services.CloudService;
import com.dota.tamirguru.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantTypeRepository merchantTypeRepository;

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private MerchantFeatureRepository merchantFeatureRepository;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private CloudService cloudService;

    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    @Cacheable(cacheNames = "merchantTypeMap")
    public Set<String> getMerchantMap() {
        return merchantTypeRepository.findTypes().stream().map(MerchantType::getTypeId).collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public MerchantResponse saveMerchant(MerchantCreateRequest request) {
        User user = jwtService.getLoggedUser();
        Merchant merchant = merchantMapper.mapRequestToEntity(request);
        merchant.setUserId(user.getId());
        merchantRepository.save(merchant);
        merchant.setDistrict(locationRepository.getDistrictById(request.getDistrictId()));
        return merchantMapper.mapEntityToResponse(merchant);
    }

    @Override
    @Transactional
    public MerchantResponse updateMerchant(MerchantUpdateRequest request) {
        User user = jwtService.getLoggedUser();
        Merchant merchant = merchantRepository.findByIdAndUserId(request.getId(), user.getId()).orElseThrow(() ->
                new GuruException(HttpStatus.BAD_REQUEST, GeneralMessageConstants.MERCHANT_NOT_FOUND, GeneralMessageConstants.MRC_NOT_FOUND));
        Merchant merchantLast = merchantMapper.mapRequestToEntity(request);
        merchantLast.setUserId(user.getId());
        merchantLast.setId(merchant.getId());
        merchantRepository.save(merchantLast);
        merchantLast.setDistrict(locationRepository.getDistrictById(request.getDistrictId()));
        return merchantMapper.mapEntityToResponse(merchantLast);
    }

    @Override
    public MerchantResponse updateMerchantPhoto(byte[] photo, Long merchantId) {
        User user = jwtService.getLoggedUser();
        Merchant merchant = merchantRepository.findByIdAndUserId(merchantId, user.getId()).orElseThrow(() ->
                new GuruException(HttpStatus.BAD_REQUEST, GeneralMessageConstants.MERCHANT_NOT_FOUND, GeneralMessageConstants.MRC_NOT_FOUND));
        merchant.setPhoto(cloudService.uploadMerchantPhoto(photo, merchantId));
        merchantRepository.save(merchant);
        return merchantMapper.mapEntityToResponse(merchant);
    }

    @Override
    @Transactional
    public List<MerchantResponse> getMerchantByDistrict(MerchantFilter filter, Pageable pageable) {
        List<Merchant> merchants = merchantRepository.filter(filter, pageable);
        List<MerchantResponse> responses = new ArrayList<>();
        for (Merchant merchant : merchants) {
            MerchantResponse response = merchantMapper.mapEntityToResponse(merchant);
            response.setFeatures(merchantMapper.featureMap(merchant.getFeatures()));
            responses.add(response);
        }
        return responses;
    }

    @Override
    public MerchantResponse findById(Long id) {
        return merchantMapper.mapEntityToResponse(merchantRepository.findById(id).orElseThrow(
                () -> new GuruException(HttpStatus.BAD_REQUEST, GeneralMessageConstants.MERCHANT_NOT_FOUND, GeneralMessageConstants.MRC_NOT_FOUND)
        ));
    }

    @Override
    public Set<MerchantFeatureResponse> findFeaturesById(Long id) {
        return merchantMapper.featureMap(merchantFeatureRepository.findByMerchantId(id));
    }

}
