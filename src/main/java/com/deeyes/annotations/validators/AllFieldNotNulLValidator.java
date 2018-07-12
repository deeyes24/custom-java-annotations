package com.deeyes.annotations.validators;

import com.deeyes.annotations.AllNotNull;

import java.lang.reflect.Field;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class AllFieldNotNulLValidator  implements  ConstraintValidator<AllNotNull, Object> {

    @Override
    public void initialize(AllNotNull constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Field[] fields = value.getClass().getDeclaredFields();
        boolean constraintsViolated = false;
        if(null!=fields) {
            for(Field classField:fields) {
                try {
                    classField.setAccessible(true);
                    Object fieldValue = classField.get(value);
                    context.disableDefaultConstraintViolation();
                    System.out.println(fieldValue);
                    if(null==fieldValue) {
                        context.buildConstraintViolationWithTemplate(classField.getName() + " is null").addConstraintViolation();
                        constraintsViolated  = true;
                    }
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return !constraintsViolated;




    }

}
