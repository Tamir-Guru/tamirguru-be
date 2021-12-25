/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.services.impl;

import com.dota.tamirguru.enums.Feature;
import com.dota.tamirguru.services.MerchantFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@SuppressWarnings("java:S2259")
public class MerchantFeatureServiceImpl implements MerchantFeatureService {

    private static final String QUERY = "SELECT id from %s";

    @Autowired
    private CacheManager cacheManager;

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    @Override
    public void init() {
        for (Feature feature : Feature.values()) {
            Query q = entityManager.createNativeQuery(String.format(QUERY, feature.getTableName()));
            List<BigInteger> results = q.getResultList();
            cacheManager.getCache(feature.getCacheName()).putIfAbsent("", results.stream().map(BigInteger::longValue).collect(Collectors.toSet()));
        }
    }

    @Override
    public boolean existsByIds(Feature feature, Set<Long> ids) {
        if (cacheManager.getCache(feature.getCacheName()) != null) {
            Cache cache = cacheManager.getCache(feature.getCacheName());
            Set<Long> longSet = cache.get("", Set.class);
            if (longSet != null) {
                return longSet.containsAll(ids);
            }
            return false;
        }
        return false;
    }


}
