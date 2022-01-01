/*
 * @author : Oguz Kahraman
 * @since : 1 Oca 2022
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.core.config;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScalarConfig {

    @Bean
    public GraphQLScalarType date() {
        return ExtendedScalars.Date;
    }

}