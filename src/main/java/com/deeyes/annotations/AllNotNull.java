package com.deeyes.annotations;

import com.deeyes.annotations.validators.AllFieldNotNulLValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


/**
 * Checks if all the fields of Annotated Class are non null using the Reflection API.
 * Works with private static fields as well.
 *
 *  Note: Fields from SuperClass are not considered for null checks.
 * @author deeyes
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AllFieldNotNulLValidator.class)
@Documented
public @interface AllNotNull  {
    String message() default "Fields values are null";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
