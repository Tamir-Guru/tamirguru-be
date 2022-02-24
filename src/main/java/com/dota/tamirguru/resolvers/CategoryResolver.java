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
import com.hero.graphqldoc.annotations.GraphQLDocDetail;
import com.hero.graphqldoc.annotations.ParameterType;
import com.hero.graphqldoc.annotations.QueryType;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@QueryType(description = "Category Query Operations", key = "Category Query")
public class CategoryResolver implements GraphQLQueryResolver {

    @Autowired
    private CategoryService categoryService;

    @GraphQLDocDetail(operation = "Get parent categories", description = "This endpoint gets parent categories")
    public List<MerchantTypeName> getParentCategories() {
        return categoryService.getParentCategories(Translator.getLanguageUpper());
    }

    @GraphQLDocDetail(operation = "Get child categories", description = "This endpoint returns child categories of given parent category")
    public List<MerchantTypeName> getCategoryFromParentId(@ParameterType(example = "1") Long parentId) {
        return categoryService.getChildCategories(parentId, Translator.getLanguageUpper());
    }

    @GraphQLDocDetail(operation = "Get all categories", description = "This endpoint returns all categories")
    public List<MerchantTypeName> getAllCategories() {
        return categoryService.getAllCategories(Translator.getLanguageUpper());
    }

}
