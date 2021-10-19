package com.envioemail.producerfila.config.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SafeTextValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SafeTextValidator {

    boolean isRequired() default true;

    String message() default "Invalid text.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
