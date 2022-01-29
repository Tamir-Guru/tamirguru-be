/*
 * @author : Oguz Kahraman
 * @since : 30 Oca 2022
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.services.impl;

import com.dota.tamirguru.constants.LocationConstant;
import com.dota.tamirguru.core.i18n.Translator;
import com.dota.tamirguru.entitites.MerchantType;
import com.dota.tamirguru.models.internals.merchant.MerchantTypeName;
import com.dota.tamirguru.repositories.MerchantTypeRepository;
import com.dota.tamirguru.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private MerchantTypeRepository merchantTypeRepository;

    @Override
    @Cacheable(cacheNames = "parentCategories")
    public List<MerchantTypeName> getParentCategories(String language) {
        List<MerchantTypeName> merchantTypeNames = new ArrayList<>();
        Set<MerchantType> allTypes = merchantTypeRepository.findParentCategories();
        allTypes.forEach(item -> merchantTypeNames
                .add(new MerchantTypeName(Translator.getMessage(LocationConstant.MERCHANT_PREFIX + item.getTypeId()), item.getTypeId(), item.getParentId(), item.getId())));
        return merchantTypeNames;
    }

    @Override
    @Cacheable(cacheNames = "childCategories")
    public List<MerchantTypeName> getChildCategories(Long parentId, String language) {
        List<MerchantTypeName> merchantTypeNames = new ArrayList<>();
        Set<MerchantType> allTypes = merchantTypeRepository.findChildCategories(parentId);
        allTypes.forEach(item -> merchantTypeNames
                .add(new MerchantTypeName(Translator.getMessage(LocationConstant.MERCHANT_PREFIX + item.getTypeId()), item.getTypeId(), item.getParentId(), item.getId())));
        return merchantTypeNames;
    }

    @Override
    @Cacheable(cacheNames = "categories")
    public List<MerchantTypeName> getAllCategories(String language) {
        List<MerchantTypeName> merchantTypeNames = new ArrayList<>();
        Set<MerchantType> allTypes = merchantTypeRepository.findTypes();
        allTypes.forEach(item -> merchantTypeNames
                .add(new MerchantTypeName(Translator.getMessage(LocationConstant.MERCHANT_PREFIX + item.getTypeId()), item.getTypeId(), item.getParentId(), item.getId())));
        return merchantTypeNames;
    }

}
