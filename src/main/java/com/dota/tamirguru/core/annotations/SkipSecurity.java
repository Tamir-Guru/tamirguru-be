/*
 * @author : Oguz Kahraman
 * @since : 20.02.2021
 *
 * Copyright - Tamir Guru Java API
 **/
package com.dota.tamirguru.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * If you add this annotation to method or fields,
 * Security interceptor skip all security checks
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface SkipSecurity {
}
