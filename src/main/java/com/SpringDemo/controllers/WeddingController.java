/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpringDemo.controllers;

import com.SpringDemo.pojo.Wedding;
import com.SpringDemo.service.WeddingService;
import java.text.ParseException;
import java.util.Date;
import jdk.internal.org.jline.utils.Colors;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/admin")
public class WeddingController {

    @Autowired
    private WeddingService weddingService;

    @GetMapping("/wedding-add")
    @Transactional
    public String addView(Model model) {
        model.addAttribute("wedding", new Wedding());
        return "Wedding";
    }

    @PostMapping("/wedding-add")
    public String addHandle(Model model, HttpSession session,
            @ModelAttribute(value = "wedding") Wedding w, @RequestParam(name = "start_date") String wedDate) throws ParseException {
            try {
                 Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(wedDate);
            w.setStartDate(date1);
            if (this.weddingService.addOrUpdateWedding(w) == true) {
            return "redirect:/";
        } else {
            session.setAttribute("errCode", "503");
        session.setAttribute("errMes", "Service Unavailable");
        return "redirect:/error";
        }
        
        } catch (Exception e) {
             session.setAttribute("errCode", "503");
        session.setAttribute("errMes", "Service Unavailable");
        return "redirect:/error";
        }
    } 
    
    
    @GetMapping("/delete")
    public String delView(Model model, @RequestParam(name = "kw", required = false) String kw,
            @RequestParam(name = "page", defaultValue = "1") Integer page) {
        String collum = "name";

        model.addAttribute("name", "Nguyen Xuan Ha");

        model.addAttribute("weddings", this.weddingService.getWeddings(kw, collum, page));
        model.addAttribute("wedCounter", this.weddingService.countWeds());
        //model.addAttribute("weds", this.wedService.getWeds());
        // model.addAttribute("user",new User());

        return "product";
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteWed(Model model,HttpSession session, @PathVariable(name = "id") String id){
        int ID = Integer.parseInt(id);
        Wedding wedding = this.weddingService.getWeddingById(ID);
        if (this.weddingService.deleteWedding(wedding)) {
            return "redirect:/";
        } else {
            session.setAttribute("errCode", "503");
        session.setAttribute("errMes", "Service Unavailable");
        return "redirect:/error";
        }
        
    }
    
    @GetMapping("/upWed/{wedId}")
    @Transactional
    public String upWed(Model model, @PathVariable(name = "wedId") int wedId) {

        model.addAttribute("wedding", this.weddingService.getWeddingById(wedId));
        return "WeddingUp";
    }
    
    @PostMapping("/upWed/{wedId}")
    public String updateSingleHandle(Model model, HttpSession session,
            @ModelAttribute(value = "wedding") Wedding w, @RequestParam(name = "start_date") String wedDate) throws ParseException {
           
            try {
                 Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(wedDate);
            w.setStartDate(date1);
            if (this.weddingService.addOrUpdateWedding(w) == true) {
            return "redirect:/";
        } else {
            session.setAttribute("errCode", "503");
        session.setAttribute("errMes", "Service Unavailable");
        return "redirect:/error";
        }
        
        } catch (Exception e) {
             session.setAttribute("errCode", "503");
        session.setAttribute("errMes", "Service Unavailable");
        return "redirect:/error";
        }
        
        
    } 
    

    
}