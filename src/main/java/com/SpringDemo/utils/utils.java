/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpringDemo.utils;

import com.SpringDemo.pojo.Cart;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author billg
 */
public class utils {
    public static Map<String, String> cartStats(Map<Integer, Cart> cart){
        int totalQuantity = 0;
        double totalAmount = 0;
        if (cart != null) {
            for (Cart c: cart.values()){
                totalQuantity += c.getQuantity();
                totalAmount += c.getQuantity() * c.getPrice();
            }
        }
        
        Map<String, String> re = new HashMap<>();
        re.put("totalAmount", String.valueOf(totalAmount));
        re.put("totalQuantity", String.valueOf(totalQuantity));
        
        return re;
    }
}
