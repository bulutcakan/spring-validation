package com.bulut.validation.validation.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EditableField {

    String name() default "";

    String description() default "";

    String fieldType() default "";

    int minLength() default 0;

    int maxLength() default 0;

    long minValue() default 0;

    long maxValue() default 0;

    int order() default 0;

    boolean required() default false;

    boolean hidden() default false;

    Class choiceModel() default Object.class;

    String selectedChoiceMappingField() default "";
}
