/*
 * @author : Oguz Kahraman
 * @since : 30 Oca 2022
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.resolvers;

import com.dota.tamirguru.core.i18n.Translator;
import com.dota.tamirguru.models.internals.merchant.MerchantTypeName;
import com.dota.tamirguru.services.CategoryService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryResolver implements GraphQLQueryResolver {

    @Autowired
    private CategoryService categoryService;

    public List<MerchantTypeName> getParentCategories() {
        return categoryService.getParentCategories(Translator.getLanguageUpper());
    }

    public List<MerchantTypeName> getCategoryFromParentId(Long parentId) {
        return categoryService.getChildCategories(parentId, Translator.getLanguageUpper());
    }

    public List<MerchantTypeName> getAllCategories() {
        return categoryService.getAllCategories(Translator.getLanguageUpper());
    }

}
