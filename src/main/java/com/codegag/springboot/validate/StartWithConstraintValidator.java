/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegag.springboot.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author DellLaptop
 */
public class StartWithConstraintValidator implements ConstraintValidator<StartWith, String>{

    private String value;
    
    @Override
    public void initialize(StartWith a){
        this.value = a.value();
    }

    @Override
    public boolean isValid(String t, ConstraintValidatorContext cvc) {
    
        if (t == null) {
            return false;
        }
        return t.startsWith(value);
    }
    
}
