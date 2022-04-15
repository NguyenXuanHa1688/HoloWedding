/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpringDemo.service.impl;

import com.SpringDemo.pojo.User;
import com.SpringDemo.repository.UserRepository;
import com.SpringDemo.service.UserService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author billg
 */
@Repository
@Transactional
@PropertySource("classpath:info.properties")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public User getUser(String Uname) {
       return this.userRepository.getUser(Uname);
    }
    @Override
    public boolean addUser(User u) {
         if (u.getFile() != null){
            try {
                Map res = this.cloudinary.uploader().upload(u.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                u.setAvatar((String) res.get("secure_url"));
                
            } catch (IOException ex) {
                Logger.getLogger(WeddingServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
       return this.userRepository.addUser(u);
    }

    @Override
    public boolean addUserByAdmin(User u, String role) {
        return  this.userRepository.addUserByAdmin(u, role);
    }
    @Override
    public boolean deleteUser(User u){
        return this.userRepository.deleteUser(u);
    }
    @Override
    public boolean updateUser(User u){
        if (u.getFile() != null){
            try {
                Map res = this.cloudinary.uploader().upload(u.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                u.setAvatar((String) res.get("secure_url"));
                
                
            } catch (IOException ex) {
                Logger.getLogger(WeddingServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.userRepository.updateUser(u);
    }
    @Override
    public  List<User> getAllUsers(){
        return this.userRepository.getAllUsers();
    }
}
