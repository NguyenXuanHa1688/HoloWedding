/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.SpringDemo.service;

import com.SpringDemo.pojo.Booking;
import java.util.List;

/**
 *
 * @author billg
 */
public interface BookingService {
    List<Booking> getBooking(String username);
    boolean addBook(Booking book);
    int countBookingByWedding̣̣̣̣̣(int wedID);
}
