/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpringDemo.controllers;

import com.SpringDemo.pojo.Comment;
import com.SpringDemo.pojo.User;
import com.SpringDemo.service.CommentService;
import java.util.Random;
import com.SpringDemo.service.UserService;
import com.SpringDemo.service.WeddingService;
import com.cloudinary.Cloudinary;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author billg
 */
@Controller
@RequestMapping("/")
@Transactional
public class CommentController {

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private WeddingService weddingService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService comService;
    @PostMapping("/comment/{wedId}")
    public String comment(Model model, HttpSession session, @PathVariable(name = "wedId") String wedId,
            @RequestParam(name = "content") String content) {
        Comment c = new Comment();

        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String strDate = dateFormat.format(date);

        c.setDateCreate(strDate);
        c.setContent(content);
        c.setIdWedding(weddingService.getWeddingById(Integer.parseInt(wedId)));
        c.setUsername(user);
        if(this.comService.addComment(c)){
            return "redirect:/weddings/"+wedId;
        }
        model.addAttribute("wedding", c.getIdWedding());
        model.addAttribute("err", "Can't comment");
        return "weddingDetail";
    }
}
