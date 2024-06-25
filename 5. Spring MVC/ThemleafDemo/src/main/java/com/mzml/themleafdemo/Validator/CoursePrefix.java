package com.mzml.themleafdemo.Validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseConstraintValidator.class)
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CoursePrefix {
    public String value() default "LUV";
    public String message() default "The course must start with LUV";
    // define default groups
    public Class<?>[] groups() default {};

    // define default payloads
    public Class<? extends Payload>[] payload() default {};
}
