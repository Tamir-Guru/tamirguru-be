/*
 * @author : Oguz Kahraman
 * @since : 28.02.2021
 *
 * Copyright - Tamir Guru Java API
 **/
package com.dota.tamirguru.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = {MerchantValidator.class, MerchantSetValidator.class})
@Target({ElementType.FIELD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Merchant {

    String message() default "{error.merchant.id}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
