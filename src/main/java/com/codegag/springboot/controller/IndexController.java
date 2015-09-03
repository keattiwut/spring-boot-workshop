/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegag.springboot.controller;

import com.codegag.springboot.domain.Comment;
import com.codegag.springboot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author DellLaptop
 */
@Controller
@RequestMapping("/")
public class IndexController {
    
    @Autowired
    private CommentService commentService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model){
        model.addAttribute("comments" , commentService.getComment());
        model.addAttribute("formComment" , new Comment());
        return "index";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String save(@ModelAttribute("formComment") Comment comment , Model model){
        model.addAttribute("commentList" , commentService.save(comment));
        model.addAttribute("formComment" , new Comment());
        return "index";
    }
}
