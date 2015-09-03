/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegag.springboot.controller;

import com.codegag.springboot.domain.Comment;
import com.codegag.springboot.service.CommentService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DellLaptop
 */
@RestController
@RequestMapping("/rest")
public class IndexRestController {
    
    @Autowired
    private CommentService commentService;
    
    @Secured("ROLE_ADMIN")
    @RequestMapping(method = RequestMethod.GET)
    public List<Comment> get(){
        return  commentService.getComment();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public List<Comment> save(@Validated @RequestBody Comment comment){
        return commentService.save(comment);
    }
    
    @RequestMapping(method = RequestMethod.DELETE)
    public List<Comment> delete(@Validated @RequestBody Comment comment){
        commentService.delete(comment);
        return commentService.getComment();
    }
    
    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.GET)
    public List<Comment> delete(@PathVariable("id") Integer id){
        commentService.delete(id);
        return commentService.getComment();
    }
    
    
    @RequestMapping(value = "/search/{search}" , method = RequestMethod.GET)
    public List<Comment> searchComment(@PathVariable("search") String search){
        return commentService.searchComment(search);
    }
    
    @RequestMapping(value = "/search/{comment}/{author}" , method = RequestMethod.GET)
    public List<Comment> searchCommentAndAuthor(@PathVariable("comment") String comment , @PathVariable("author")String author){
        return commentService.searchCommentAndAuthor(comment, author);
    }
    
    
    @RequestMapping(value = "/find/between/" , method = RequestMethod.POST)
    public List<Comment> findByCreateDate(@RequestBody Map<String,Date> map){
        return commentService.findCreateDateBetween(map.get("start") , map.get("end"));
    }
    
    @RequestMapping(value = "/find/any/" , method = RequestMethod.GET)
    public List<Comment> findByAny(){
        return commentService.findByAnything();
    }
    
}

