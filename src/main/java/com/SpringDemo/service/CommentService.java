/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.SpringDemo.service;

import com.SpringDemo.pojo.Comment;
import java.util.List;

/**
 *
 * @author billg
 */
public interface CommentService {
    List<Comment> getComments(int idWed);
    boolean addComment(Comment c);
}