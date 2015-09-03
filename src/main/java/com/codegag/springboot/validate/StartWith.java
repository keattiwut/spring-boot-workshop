/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegag.springboot.validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author DellLaptop
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StartWithConstraintValidator.class)
public @interface StartWith {
    
    public String value() default "";

    public String message() default "Start with error";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};

}
