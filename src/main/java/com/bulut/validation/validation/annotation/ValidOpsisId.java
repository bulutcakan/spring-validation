package com.bulut.validation.validation.annotation;


import com.migros.common.validation.OpsisIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OpsisIdValidator.class)
public @interface ValidOpsisId {

    String message() default "Opsis Id not valid !! The id must contains only numeric characters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
