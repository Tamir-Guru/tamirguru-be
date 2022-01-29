/*
 * @author : Oguz Kahraman
 * @since : 30 Oca 2022
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.services;

import com.dota.tamirguru.models.internals.merchant.MerchantTypeName;

import java.util.List;

public interface CategoryService {
    List<MerchantTypeName> getParentCategories(String language);

    List<MerchantTypeName> getChildCategories(Long parentId, String language);

    List<MerchantTypeName> getAllCategories(String language);
}
