/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.SpringDemo.repository;

import com.SpringDemo.pojo.User;
import java.util.List;

/**
 *
 * @author billg
 */
public interface UserRepository {
     User getUser(String Uname);
     boolean addUser(User u);
     boolean addUserByAdmin(User u, String role);
     boolean deleteUser(User u);
     boolean updateUser(User u);
     List<User> getAllUsers();
}
