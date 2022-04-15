/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpringDemo.controllers;

import com.SpringDemo.pojo.User;
import com.SpringDemo.pojo.Wedding;
import com.SpringDemo.service.UserService;
import java.security.MessageDigest;
import javax.swing.JOptionPane;
import com.SpringDemo.service.WeddingService;
import com.cloudinary.Cloudinary;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author billg
 */
@Controller
@RequestMapping("/")
@Transactional
public class UserController {

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private WeddingService weddingService;
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginView(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginHandler(Model model, HttpSession session, @ModelAttribute(value = "user") User user) {
        User u;
        try {

            u = this.userService.getUser(user.getUsername());
            if (user.getPassword().equals(u.getPassword())) {

                session.setAttribute("user", u);
                return "redirect:/";
            }
            return "redirect:/login";

        } catch (Exception e) {
            return "redirect:/login";
        }

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("user", null);
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String addView(Model model) {
        model.addAttribute("user", new User());
        return "register";

    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "user") User u) {
        if (this.userService.addUser(u) == true) {
            return "redirect:/";
        } else {
            model.addAttribute("errMSg", "ERROR");
        }
        return "redirect:/register";
    }

    @PostMapping("/admin/addEmp")
    public String addEmp(Model model, HttpSession session, @ModelAttribute(value = "user") User u) {
        if (this.userService.addUserByAdmin(u, u.getRole()) == true) {
            return "redirect:/admin/manager";
        } else {
            session.setAttribute("errCode", "503");
            session.setAttribute("errMes", "Service Unavailable");
            return "redirect:/error";
        }
    }

    @GetMapping("/admin/deleteEmp/{username}")
    public String deleteEmp(Model model, HttpSession session, @PathVariable(name = "username") String username) {
        User user = this.userService.getUser(username);
        if (this.userService.deleteUser(user)) {
            return "redirect:/admin/manager";
        }
        session.setAttribute("errCode", "503");
        session.setAttribute("errMes", "Service Unavailable");
        return "redirect:/error";
    }

    @PostMapping("/admin/editEmp")
    public String editEmp(Model model,HttpSession session, @ModelAttribute(value = "user") User user) {
        if (this.userService.addUser(user) == true) {
            return "redirect:/";
        } else {
            session.setAttribute("errCode", "503");
            session.setAttribute("errMes", "Service Unavailable");
            return "redirect:/error";
        }
    }

    @PostMapping("/profile/updateprofile")
    @Transactional
    public String editUser(Model model, HttpSession session, @ModelAttribute(value = "user") User user) {

        User u = (User) session.getAttribute("user");
        
        user.setUsername(u.getUsername());
        user.setAvatar(u.getAvatar());
        user.setRole(u.getRole());
        if (this.userService.updateUser(user) == true) {
            session.setAttribute("user", this.userService.getUser(user.getUsername()));
            return "redirect:/profile";
        } else {
            model.addAttribute("errMSg", "ERROR");
        }
        return "redirect:/profile";
    }

    @PostMapping("/up_avatar")
    public String updateAvatar(Model model, @ModelAttribute(value = "user") User user, HttpSession session) {
        User u = (User) session.getAttribute("user");
        user.setUsername(u.getUsername());
        user.setPassword(u.getPassword());
        if (this.userService.updateUser(user) == true) {
            session.setAttribute("user", this.userService.getUser(user.getUsername()));
            return "redirect:/profile";
        } else {
            model.addAttribute("errMSg", "ERROR");
        }
        return "redirect:/profile";
    }
}
