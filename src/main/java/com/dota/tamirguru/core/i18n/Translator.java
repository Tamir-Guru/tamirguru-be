/*
 * @author : Oguz Kahraman
 * @since : 22.02.2021
 *
 * Copyright - Tamir Guru Java API
 **/
package com.dota.tamirguru.core.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@SuppressWarnings("java:S3010")
public class Translator {

    public static final Locale DEFAULT_LOCALE = new Locale("tr");

    private static ResourceBundleMessageSource messageSource;

    @Autowired
    private Translator(ResourceBundleMessageSource messageSource) {
        Translator.messageSource = messageSource;
    }

    public static String getMessage(String message) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(message, null, locale);
    }

    public static String getMessage(String message, Object... args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(message, args, locale);
    }

    public static Locale getLanguage() {
        return LocaleContextHolder.getLocale();
    }

    public static String getLanguageUpper() {
        return LocaleContextHolder.getLocale().getLanguage().toUpperCase(Locale.UK);
    }

    public static String getDefaultLanguageUpper() {
        return DEFAULT_LOCALE.getLanguage().toUpperCase(Locale.UK);
    }
}