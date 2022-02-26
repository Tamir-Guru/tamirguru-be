/*
 * @author : Oguz Kahraman
 * @since : 26 Şub 2022
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.core.config;

import graphql.kickstart.servlet.apollo.ApolloScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScalarConfig {

    @Bean
    public GraphQLScalarType uploadScalar() {
        return ApolloScalars.Upload;
    }

}
