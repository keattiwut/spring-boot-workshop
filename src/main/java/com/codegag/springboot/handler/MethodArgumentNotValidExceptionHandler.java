/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegag.springboot.handler;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author DellLaptop
 */
@ControllerAdvice
public class MethodArgumentNotValidExceptionHandler {
    
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,Object> handler(MethodArgumentNotValidException ex){
        Map<String , Object> mapHandler = new HashMap<>();

        for (FieldError er : ex.getBindingResult().getFieldErrors()) {
            mapHandler.put("Error : ", er.getField() + " " + er.getDefaultMessage());
        }
        return mapHandler;
    }
}
