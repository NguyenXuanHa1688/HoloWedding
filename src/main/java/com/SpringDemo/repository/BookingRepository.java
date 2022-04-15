/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.SpringDemo.repository;

import com.SpringDemo.pojo.Booking;
import java.util.List;

/**
 *
 * @author billg
 */
public interface BookingRepository {
    List<Booking> getBooking(String username);
    boolean addBook(Booking book);
    int countBookingByWedding̣̣̣̣̣(int wedID);
}