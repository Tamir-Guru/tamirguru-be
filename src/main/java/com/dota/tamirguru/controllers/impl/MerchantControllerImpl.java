/*
 * @author : Oguz Kahraman
 * @since : 23 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.controllers.impl;

import com.dota.tamirguru.controllers.MerchantController;
import com.dota.tamirguru.core.annotations.SkipSecurity;
import com.dota.tamirguru.core.i18n.Translator;
import com.dota.tamirguru.models.internals.merchant.MerchantTypeName;
import com.dota.tamirguru.models.requests.merchant.MerchantCreateRequest;
import com.dota.tamirguru.models.requests.merchant.MerchantFilter;
import com.dota.tamirguru.models.responses.merchant.MerchantResponse;
import com.dota.tamirguru.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MerchantControllerImpl implements MerchantController {

    @Autowired
    private MerchantService merchantService;

    @Override
    public ResponseEntity<List<MerchantTypeName>> getMerchantTypes() {
        return ResponseEntity.ok(merchantService.getMerchants(Translator.getLanguageUpper()));
    }

    @Override
    @PreAuthorize("hasRole('ROLE_COMMERCIAL')")
    public ResponseEntity<MerchantResponse> createMerchant(@Valid MerchantCreateRequest request) {
        Long id = merchantService.saveMerchant(request);
        return ResponseEntity.ok(merchantService.getMerchantFromId(id));
    }

    @Override
    @SkipSecurity
    public ResponseEntity<List<MerchantResponse>> findMerchantsFromDistrictId(@Valid MerchantFilter merchantFilter, Integer pageNumber, Integer pageSize) {
        return ResponseEntity.ok(merchantService.getMerchantByDistrict(merchantFilter, PageRequest.of(pageNumber - 1, pageSize, Sort.by("name").ascending())));
    }

}
