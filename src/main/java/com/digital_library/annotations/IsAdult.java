package com.digital_library.annotations;



import com.digital_library.validator.IsAdultValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IsAdultValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsAdult {
    String message() default "ETO YZE NAY4NAYA RABOTA,A NE ARTICLE";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
