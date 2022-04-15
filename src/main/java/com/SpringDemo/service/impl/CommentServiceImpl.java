/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpringDemo.service.impl;

import com.SpringDemo.pojo.Comment;
import com.SpringDemo.repository.CommentRepository;
import com.SpringDemo.service.CommentService;
import com.cloudinary.Cloudinary;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author billg
 */
@Repository
@Transactional
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<Comment> getComments(int idWed) {
        return this.commentRepository.getComments(idWed);
    }

    @Override
    public boolean addComment(Comment c) {
        return this.commentRepository.addComment(c);
    }
    
}
