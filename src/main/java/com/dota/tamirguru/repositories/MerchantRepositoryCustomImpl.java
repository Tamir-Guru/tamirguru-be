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

    private static final String QUERY_START1 = "SELECT DISTINCT mrc.* from (select mrc.* ";
    private static final String QUERY_START2 = "from merchants mrc " +
            " left outer join districts district0_ on mrc.district_id = district0_.id" +
            " left outer join cities city1_ on district0_.city_id = city1_.city_code" +
            " left outer join merchant_features merchant_features_1_ on merchant_features_1_.merchant_id = mrc.id ";
    private static final String QUERY_END = ") mrc ";
    private static final String DISTANCE_FILTER = "where mrc.distance < %d order by mrc.distance ";

    private static final String DISTANCE_QUERY = ", (3959 *" +
            " acos(cos(radians(%f)) * cos(radians(latitude)) * cos(radians(longitude) - radians(%f)) +" +
            " sin(radians(%f)) * sin(radians(latitude)))) * 1.609344 AS distance ";

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Merchant> filter(MerchantFilter filter, Pageable pageable) {
        StringBuilder str = new StringBuilder(QUERY_START1);
        List<String> conditions = new ArrayList<>();
        boolean isDitance = filterByDistance(filter, str);
        str.append(QUERY_START2);
        if (filter != null) {
            filterByType(filter, conditions);
            filterByCity(filter, conditions);
            filterByDistrict(filter, conditions);
            filterByFeatures(filter, conditions);
            filterByFeatureValues(filter, conditions);
        }
        createQuery(str, conditions);
        str.append(QUERY_END);
        if (isDitance) {
            str.append(String.format(DISTANCE_FILTER, filter.getDistance().getDistance()));
        }
        createPagination(pageable, str);
        Query q = entityManager.createNativeQuery(str.toString(), Merchant.class);
        return q.getResultList();
    }

    private boolean filterByDistance(MerchantFilter filter, StringBuilder str) {
        if (filter != null && filter.getDistance() != null) {
            str.append(String.format(DISTANCE_QUERY, filter.getDistance().getLatitude(), filter.getDistance().getLongitude(),
                    filter.getDistance().getLatitude()));
            return true;
        }
        return false;
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
        if (!filter.getDistricts().isEmpty()) {
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

    private void filterByFeatures(MerchantFilter filter, List<String> conditions) {
        if (!filter.getFeatures().isEmpty()) {
            StringBuilder builder = new StringBuilder("merchant_features_1_.type in (");
            String prefix = "";
            for (String feature : filter.getFeatures()) {
                builder.append(prefix);
                prefix = ",";
                builder.append('\'').append(feature).append('\'');
            }
            builder.append(")");
            conditions.add(builder.toString());
        }
    }

    private void filterByFeatureValues(MerchantFilter filter, List<String> conditions) {
        if (filter.getValues() != null && !filter.getValues().isEmpty()) {
            StringBuilder builder = new StringBuilder("ARRAY[");
            genericNumberIn(builder, filter.getValues());
            builder.append("] && merchant_features_1_.values");
            conditions.add(builder.toString());
        }
    }

    private void createQuery(StringBuilder str, List<String> conditions) {
        str.append("where mrc.approved = true ");
        if (!conditions.isEmpty()) {
            str.append(" and ");
            for (int i = 0; i < conditions.size(); i++) {
                str.append(conditions.get(i));
                if (i < conditions.size() - 1) {
                    str.append(" and ");
                }
            }
        }
    }

    private void createPagination(Pageable pageable, StringBuilder str) {
        str.append(" limit ").append(pageable.getPageSize()).append(" offset ").append(pageable.getPageNumber() * pageable.getPageSize()).append(";");
    }

    private void genericStringIn(StringBuilder builder, Set<String> types) {
        String prefix = "";
        for (String type : types) {
            builder.append(prefix);
            prefix = ",";
            builder.append('\'').append(type).append('\'');
        }
    }

    private void genericNumberIn(StringBuilder builder, Set<? extends Number> types) {
        String prefix = "";
        for (Number type : types) {
            builder.append(prefix);
            prefix = ",";
            builder.append(type).append("\\:\\:bigint");
        }
    }

}