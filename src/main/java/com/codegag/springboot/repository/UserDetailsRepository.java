/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegag.springboot.repository;

import com.codegag.springboot.domain.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author DellLaptop
 */
public interface UserDetailsRepository extends JpaRepository<UserDetails, String>{
    
}
