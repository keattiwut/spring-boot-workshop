/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegag.springboot.repository;

import com.codegag.springboot.domain.Comment;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author DellLaptop
 */
public interface CommentRepository extends JpaRepository<Comment, Integer>{
    
    public List<Comment> findByCommentLike(String search);
    
    public List<Comment> findByCommentAndAuthor(String comment , String author);
    
    public List<Comment> findByCreateDateBetween (Date start , Date end);;
    
    @Query(value = "SELECT c FROM Comment c")
    public List<Comment> findByAnything();
}
