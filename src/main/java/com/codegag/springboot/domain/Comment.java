/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegag.springboot.domain;

import com.codegag.springboot.validate.StartWith;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author DellLaptop
 */

@Entity
public class Comment {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @NotBlank(message = "Comment can't be blank")
    private String comment;
    
    @StartWith("Mr.")
    @NotBlank(message = "Author can't be blank")
    private String author;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    
    
    @PrePersist
    private void insertCreateDate(){
        if (this.createDate == null) {
            this.createDate = new Date();
        }
    }
    
}
