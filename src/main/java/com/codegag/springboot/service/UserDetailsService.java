/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegag.springboot.service;

import com.codegag.springboot.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author DellLaptop
 */
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

    @Autowired
    private UserDetailsRepository userDetailsRepository;
    
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        return userDetailsRepository.findOne(string);
    }
    
}
