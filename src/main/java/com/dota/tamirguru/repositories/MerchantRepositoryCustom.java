package com.dota.tamirguru.repositories;

import com.dota.tamirguru.entitites.Merchant;
import com.dota.tamirguru.models.requests.merchant.MerchantFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MerchantRepositoryCustom {

    List<Merchant> filter(MerchantFilter filter, Pageable pageable);

}