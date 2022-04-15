/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpringDemo.controllers;

//import com.SpringDemo.pojo.User;
import com.SpringDemo.pojo.Booking;
import com.SpringDemo.pojo.Comment;
import com.SpringDemo.pojo.User;
import com.SpringDemo.pojo.Wedding;
import com.SpringDemo.service.BookingService;
import com.SpringDemo.service.CommentService;
import com.SpringDemo.service.UserService;
import com.SpringDemo.service.WeddingService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import com.mysql.cj.xdevapi.SessionFactory;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.criteria.Predicate;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.annotations.common.reflection.XClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
public class HomeController {

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
    @Autowired
    private BookingService bookingService;

    @RequestMapping("/")
    @Transactional
    public String index(Model model, HttpSession session, @RequestParam(name = "kw", required = false) String kw,
            @RequestParam(name = "page", defaultValue = "1") Integer page) {
        String collum = "name";
        User user = (User) session.getAttribute("user");

        model.addAttribute("name", "Nguyen Xuan Ha");

        model.addAttribute("weddings", this.weddingService.getWeddings(kw, collum, page));
        model.addAttribute("wedCounter", this.weddingService.countWeds());
        //model.addAttribute("weds", this.wedService.getWeds());
        // model.addAttribute("user",new User());
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping("/search")
    @Transactional
    public String search(Model model, @RequestParam(name = "sname", required = false) String kw,
            @RequestParam(name = "page", defaultValue = "1") Integer page) {

        model.addAttribute("weddings", this.weddingService.getWeddings(kw, "name", page));

        model.addAttribute("wedCounter", this.weddingService.countWeds());
        return "product";
    }

    //   @PostMapping("/upload")
    //  public String upload(@ModelAttribute(value="user")User user){
    //      try {
    //         Map res = this.cloudinary.uploader().upload(user.getAvatar().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
    //         System.err.println(res);
    //     } catch (IOException ex) {
    //         Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
    //     }
    //    return "redirect:/login?path=test";
    //  }
    @RequestMapping("/error")
    public String GetPath(Model model, HttpSession session) {
        if ((String) session.getAttribute("errCode") != null) {
            model.addAttribute("errorCode", (String) session.getAttribute("errCode"));
            model.addAttribute("errMes", (String) session.getAttribute("errMes"));
            return "errorPage";
        } else {
            model.addAttribute("errorCode", "404");
            model.addAttribute("errMes", "NOT FOUND");
            return "errorPage";
        }

    }

    @RequestMapping("/weddings/{idWedding}")
    public String weddingDetail(Model model,
            @PathVariable(name = "idWedding") int id) {

        List<Comment> comments = this.comService.getComments(id);

        for (int i = 0; i < comments.size(); i++) {
            Comment com = comments.get(i);
            if (com.getIdWedding().getIdWedding() != id) {
                comments.remove(com);
            }
        }

        model.addAttribute("comments", comments);
        model.addAttribute("count", this.bookingService.countBookingByWedding̣̣̣̣̣(id));
        model.addAttribute("wedding", this.weddingService.getWeddingById(id));

        return "weddingDetail";
    }

    @RequestMapping("/Hello2")
    public String Hello2(Model model, @RequestParam(required = false) Map<String, String> params) {
        String fn = params.get("firstName");
        String ln = params.get("lastName");
        model.addAttribute("name", fn + " " + ln);
        return "index";
    }

    @GetMapping("/chartBooking")//
    public String getData(Model model) {
        List<Wedding> weddings = this.weddingService.getAllWeddings();
        Map<String, Integer> chartMap = new HashMap<>();
        for (int i = 0; i < weddings.size(); i++) {
            Wedding wed = weddings.get(i);
            int tmp = this.bookingService.countBookingByWedding̣̣̣̣̣(wed.getIdWedding());
            chartMap.put(wed.getName(), tmp);
        }
        model.addAttribute("chartdata", chartMap);
        return "report";
    }

    @RequestMapping("/admin")
    public String adminIndex(Model model) {
        model.addAttribute("name", "Nguyen Xuan Ha");

        model.addAttribute("weddings", this.weddingService.getWeddings("", "name", 1));
        model.addAttribute("wedCounter", this.weddingService.countWeds());
        //model.addAttribute("weds", this.wedService.getWeds());
        // model.addAttribute("user",new User());
        return "index";
    }

    @GetMapping("/product")
    public String ProductView(Model model, @RequestParam(name = "page", defaultValue = "1") Integer page) {
        model.addAttribute("weddings", this.weddingService.getWeddings("", "name", page));
        model.addAttribute("wedCounter", this.weddingService.countWeds());
        model.addAttribute("descSort", this.weddingService.SortDescWeddings());
        return "product";
    }

    @GetMapping("/profile")
    public String ProfileView(Model model, HttpSession session, @RequestParam(name = "page", defaultValue = "1") Integer page) {
        User user = (User) session.getAttribute("user");
        List<Booking> bookings = this.bookingService.getBooking(user.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("bookings", bookings);
        return "profile";
    }

    @GetMapping("/admin/manager")
    public String UserView(Model model, HttpSession session, @RequestParam(name = "page", defaultValue = "1") Integer page) {
        User user = (User) session.getAttribute("user");
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("user", user);
        model.addAttribute("users", users);
        return "empManager";
    }

    @Transactional
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource message = new ResourceBundleMessageSource();
        message.setBasenames("message");

        return message;
    }

    @RequestMapping("/about")
    public String aboutView(Model model) {
        return "about";
    }

    @GetMapping("/descsort")
    public String SortView(Model model, @RequestParam(name = "page", defaultValue = "1") Integer page) {

        model.addAttribute("wedCounter", this.weddingService.countWeds());
        model.addAttribute("weddings", this.weddingService.SortDescWeddings());
        return "product";
    }

    @GetMapping("/ascsort")
    public String Sort2View(Model model, @RequestParam(name = "page", defaultValue = "1") Integer page) {

        model.addAttribute("wedCounter", this.weddingService.countWeds());
        model.addAttribute("weddings", this.weddingService.ascDescWeddings());
        return "product";
    }
}
