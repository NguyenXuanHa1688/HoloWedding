/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpringDemo.controllers;

import com.SpringDemo.pojo.Booking;
import com.SpringDemo.pojo.User;
import com.SpringDemo.pojo.Wedding;
import com.SpringDemo.service.BookingService;
import com.SpringDemo.service.UserService;
import com.SpringDemo.service.WeddingService;
import com.cloudinary.Cloudinary;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
public class BookingController {

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private WeddingService weddingService;
    @Autowired
    private UserService userService;
    @Autowired
    private BookingService bookingService;
    @GetMapping("/book/{wedId}")
    @Transactional
    public String Book(Model model, @PathVariable(name = "wedId") int wedId) {

        model.addAttribute("wedding", this.weddingService.getWeddingById(wedId));
        return "Booking";
    }

    @PostMapping("/book/{wedId}")
    public String Booking(Model model, HttpSession session,
            @RequestParam(name = "totalPrice") int totalPrice,
            @PathVariable(name = "wedId") int wedId) {
        
        User user = (User) session.getAttribute("user");
        Wedding wedding = this.weddingService.getWeddingById(wedId);
        Booking booking = new Booking();
        booking.setUsername(user);
        booking.setTotalPrice(totalPrice);
        booking.setIdWedding(wedding);
        if (user == null) {
            return "redirect:/login";
        }
        
        if (this.bookingService.addBook(booking) == true) {
            return "redirect:/";
        } else {
            model.addAttribute("errMSg", "ERROR");
        }
        return "redirect:/book/"+wedId;
        
    }

}
