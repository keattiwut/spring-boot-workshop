/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegag.springboot.service;

import com.codegag.springboot.domain.Comment;
import com.codegag.springboot.repository.CommentRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DellLaptop
 */

@Service
public class CommentService {
    
    @Autowired
    private CommentRepository commentRepository;
    
    public List<Comment> getComment() {
        return commentRepository.findAll();
    }

    public List<Comment> save(Comment comment) {
        commentRepository.save(comment);
        return getComment();
    }

    public List<Comment> delete(Comment comment) {
        commentRepository.delete(comment);
        return getComment();
    }

    public List<Comment> delete(Integer id) {
        commentRepository.delete(id);
        return getComment();
    }
    
    public List<Comment> searchComment(String search){
        return commentRepository.findByCommentLike("%" +search+ "");
    }
    
    
    public List<Comment> searchCommentAndAuthor(String comment , String author){
        return commentRepository.findByCommentAndAuthor(comment, author);
    }
    
    public List<Comment> findCreateDateBetween(Date start , Date end){
        return commentRepository.findByCreateDateBetween(start, end);
    }

    public List<Comment> findByAnything() {
        return commentRepository.findByAnything();
    }
    
}
