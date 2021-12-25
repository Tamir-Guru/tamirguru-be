package com.dota.tamirguru.repositories;

import com.dota.tamirguru.entitites.Merchant;
import com.dota.tamirguru.models.requests.merchant.MerchantFilter;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MerchantRepositoryCustomImpl implements MerchantRepositoryCustom {

    private static final String QUERY = "SELECT * from merchants mrc " +
            " left outer join districts district0_ on mrc.district_id = district0_.id" +
            " left outer join cities city1_ on district0_.city_id = city1_.city_code ";

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Merchant> filter(MerchantFilter filter, Pageable pageable) {
        StringBuilder str = new StringBuilder(QUERY);
        List<String> conditions = new ArrayList<>();
        filterByType(filter, conditions);
        filterByCity(filter, conditions);
        filterByDistrict(filter, conditions);
        createQueryAndPagination(pageable, str, conditions);
        Query q = entityManager.createNativeQuery(str.toString(), Merchant.class);
        return q.getResultList();
    }

    private void filterByType(MerchantFilter filter, List<String> conditions) {
        if (!filter.getTypes().isEmpty()) {
            StringBuilder builder = new StringBuilder("ARRAY[");
            genericStringIn(builder, filter.getTypes());
            builder.append("] && mrc.merchant_types");
            conditions.add(builder.toString());
        }
    }

    private void filterByCity(MerchantFilter filter, List<String> conditions) {
        if (!filter.getCities().isEmpty()) {
            StringBuilder builder = new StringBuilder("city1_.city_code in (");
            genericStringIn(builder, filter.getCities());
            builder.append(")");
            conditions.add(builder.toString());
        }
    }

    private void filterByDistrict(MerchantFilter filter, List<String> conditions) {
        if (!filter.getCities().isEmpty()) {
            StringBuilder builder = new StringBuilder("mrc.district_id in (");
            String prefix = "";
            for (Long district : filter.getDistricts()) {
                builder.append(prefix);
                prefix = ",";
                builder.append(district);
            }
            builder.append(")");
            conditions.add(builder.toString());
        }
    }

    private void createQueryAndPagination(Pageable pageable, StringBuilder str, List<String> conditions) {
        if (!conditions.isEmpty()) {
            str.append("where ");
            for (int i = 0; i < conditions.size(); i++) {
                str.append(conditions.get(i));
                if (i < conditions.size() - 1) {
                    str.append(" and ");
                }
            }
        }
        str.append(" limit ").append(pageable.getPageSize()).append(" offset ").append(pageable.getPageNumber() * pageable.getPageSize());
    }

    private void genericStringIn(StringBuilder builder, Set<String> types) {
        String prefix = "";
        for (String type : types) {
            builder.append(prefix);
            prefix = ",";
            builder.append('\'').append(type).append('\'');
        }
    }

}