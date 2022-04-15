/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpringDemo.service.impl;

import com.SpringDemo.pojo.Booking;
import com.SpringDemo.repository.BookingRepository;
import com.SpringDemo.repository.UserRepository;
import com.SpringDemo.repository.WeddingRepository;
import com.SpringDemo.service.BookingService;
import com.cloudinary.Cloudinary;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author billg
 */
@Repository
@Transactional
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private Cloudinary cloudinary;
    
    
    
    @Override
    public List<Booking> getBooking(String username) {
        return this.bookingRepository.getBooking(username);
    }

    @Override
    public boolean addBook(Booking book) {
        return this.bookingRepository.addBook(book);
    }
    @Override
    public int countBookingByWedding̣̣̣̣̣(int wedID){
        return this.bookingRepository.countBookingByWedding̣̣̣̣̣(wedID);
    }
}
