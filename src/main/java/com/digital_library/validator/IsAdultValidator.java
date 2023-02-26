package com.digital_library.validator;

import com.digital_library.annotations.IsShort;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsShortValidator implements ConstraintValidator<IsShort,Integer> {

    @Override
    public void initialize(IsShort constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        return value >=;
    }
}
