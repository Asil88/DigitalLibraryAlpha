package com.digital_library.validator;

import com.digital_library.annotations.IsAdult;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsAdultValidator implements ConstraintValidator<IsAdult,Integer> {

    @Override
    public void initialize(IsAdult constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        return value >= 18;
    }
}
