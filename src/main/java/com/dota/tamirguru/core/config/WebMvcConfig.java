/*
 * @author : Oguz Kahraman
 * @since : 12.02.2021
 *
 * Copyright - Collige Java API
 **/
package com.dota.tamirguru.core.config;

import com.dota.tamirguru.core.i18n.CalendarLocaleResolver;
import com.dota.tamirguru.core.i18n.Translator;
import com.dota.tamirguru.core.security.jwt.JWTInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver defaultViewResolver() {
        return new InternalResourceViewResolver();
    }

    @Bean
    public JWTInterceptor jwtInterceptor() {
        return new JWTInterceptor();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                .excludePathPatterns(
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/index.html",
                        "/",
                        "/error",
                        "/error.html",
                        "/document.html",
                        "/document",
                        "/favicon.ico",
                        "/users/verifyEmail",
                        "/merchants/types",
                        "/login",
                        "/resendVerification",
                        "/cities",
                        "/districts",
                        "/countries",
                        "/resetPassword"
                )
                .pathMatcher(new AntPathMatcher());
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
        rs.addBasenames("messages/error/error_messages",
                "messages/app/app_messages",
                "messages/validation/validation_messages",
                "messages/multivalues/city_values",
                "messages/multivalues/country_values",
                "messages/multivalues/district_values",
                "messages/multivalues/merchant_types",
                "org/hibernate/validator/ValidationMessages");
        rs.setDefaultEncoding("UTF-8");
        rs.setDefaultLocale(Translator.DEFAULT_LOCALE);
        rs.setUseCodeAsDefaultMessage(false);
        return rs;
    }

    @Bean
    @Override
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Bean
    public LocaleResolver localeResolver() {
        CalendarLocaleResolver resolver = new CalendarLocaleResolver();
        resolver.setDefaultLocale(Translator.DEFAULT_LOCALE);
        return resolver;
    }

}
