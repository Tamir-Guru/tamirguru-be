/*
 * @author : Oguz Kahraman
 * @since : 25 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = MerchantFeatureValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MerchantFeature {

    String message() default "{error.merchant.feature}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
